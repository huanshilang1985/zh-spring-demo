package org.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 模拟手动装配
 *
 * @author he.zhang
 * @date 2020/2/25 16:25
 */
public class BeanFactory {

    // 用来保存spring.xml的bean关系
    Map<String, Object> map = new HashMap<>();

    /**
     * 构造方法，提供配置信息
     */
    public BeanFactory(String xml) {
        parseXml(xml);
    }


    /**
     * 解析XML
     *
     * @param xml 描述信息
     */
    public void parseXml(String xml) {
        // this.getClass().getResource("/")是得到class目录
        try {
            File file = new File(this.getClass().getResource("/").getPath() + "//" + xml);

            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();

            Object object = null;
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
                /**
                 * setup 2 维护依赖关系
                 * 看这个对象有没有依赖，
                 * 取2级子标签
                 */

                for (Iterator<Element> itSecond = elementFirstCli.elementIterator(); itSecond.hasNext(); ) {
                    Element elementSecondChi = itSecond.next();

                    /**
                     * <property name="dao" ref="dao" />
                     * 得到ref的value，通过value得到对象(map)
                     * 得到name的值，根据值获取一个Field的对象，通过Field确认set那个方法
                     */
                    if ("property".equals(elementSecondChi.getName())) {
                        // 由于是setter，没有特殊的构造方法，可以直接newInstance;
                        object = clazz.newInstance();
                        String refValue = elementSecondChi.attribute("ref").getValue();
                        Object injectObject = map.get(refValue);
                        String nameValue = elementSecondChi.attribute("name").getValue();
                        // 拿到属性方法，这里会自动对应set方法
                        Field field = clazz.getDeclaredField(nameValue);
                        // 开启访问权限
                        field.setAccessible(true);
                        // object当前对象，insertObject要set的值
                        field.set(object, injectObject);
                    } else if ("constructor-arg".equals(elementSecondChi.getName())) {
                        // 证明有特殊构造方法。这个方法只支持单个参数的构造方法，多个参数的还需要另写
                        String refValue = elementSecondChi.attribute("ref").getValue();
                        Object injectObject = map.get(refValue);
                        // 得到类的类型
                        Class<?> injectObjectClazz = injectObject.getClass();
                        //　得到构造方法，在spring.xml中配置的是实现类，但构造方法的属性dao是接口类
                        Constructor<?> constructor = clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                        object = constructor.newInstance(injectObject);
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
