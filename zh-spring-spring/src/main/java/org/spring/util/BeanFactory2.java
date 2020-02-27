package org.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 模拟自动装配
 *
 * @author he.zhang
 * @date 2020/2/25 16:25
 */
public class BeanFactory2 {

    /**
     * 用来保存spring.xml的bean关系
     */
    Map<String, Object> map = new HashMap<>();

    /**
     * 构造方法，提供配置信息
     */
    public BeanFactory2(String xml) {
        parseXml(xml);
    }


    /**
     * 解析XML
     *
     * @param xml 描述信息
     */
    public void parseXml(String xml) throws MySpringException {
        try {
            // this.getClass().getResource("/")是得到class目录
            File file = new File(this.getClass().getResource("/").getPath() + "//" + xml);

            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();

            // 判断是否自动装配
            Attribute attribute = rootElement.attribute("default");
            boolean flag = false;
            if (attribute != null) {
                flag = true;
            }


            // 使用迭代器会更安全，forEach可能会报错
            for (Iterator<Element> itFirst = rootElement.elementIterator(); itFirst.hasNext(); ) {
                /**
                 * setup 1
                 * 实例化对象，取1级子标签
                 */
                Element elementFirstCli = itFirst.next();
                // 取XML里的id属性
                Attribute attributeId = elementFirstCli.attribute("id");
                String beanName = attributeId.getValue();
                // 取spring.xml里的class的属性
                Attribute attributeClass = elementFirstCli.attribute("class");
                String clazzName = attributeClass.getValue();
                Class<?> clazz = Class.forName(clazzName);

                // 采用自动装配，
                Object object = null;
                if(flag){
                    if ("byType".equals(attribute.getValue())){
                        // 判断是否有依赖，拿到所有属性
                        Field[] fields = clazz.getDeclaredFields();
                        for(Field field : fields){
                            // 得到属性的类型，比如String aa，name这里的 field.getType()=String.class
                            Class<?> injectObjectClazz = field.getType();
                            // 由于是byType，所以需要遍历map当中的所有对象，判断对象的类型是不是和injectObjectClazz相同
                            int count = 0;
                            Object injectObject = null;
                            for(String key : map.keySet()){
                                // map.get(key).getClass()取的是实现类，我们需要取它的接口来比较
                                Class temp = map.get(key).getClass().getInterfaces()[0];
                                if(temp.getName().equals(injectObjectClazz.getName())){
                                    injectObject = map.get(key);
                                    // 记录了找到一个，因为可能找到多个
                                    count++;
                                }
                            }
                            if(count > 1){
                                throw new MySpringException("需要一个对象，但是找到2个对象");
                            } else {
                                // 把service当前类new一个新对象
                                object = clazz.newInstance();
                                // 开启访问权限
                                field.setAccessible(true);
                                // 把dao属性注入给service
                                field.set(object, injectObject);
                            }
                        }
                    }
                }
                // spring.xml没有子标签，表示没有依赖关系
                if(object == null){
                    object = clazz.newInstance();
                }
                map.put(beanName, object);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    /**
     * BeanFactory的主要方法，或者对象信息
     *
     * @param beanName bean的名称
     * @return Object
     */
    public Object getBean(String beanName) {
        return map.get(beanName);
    }


}
