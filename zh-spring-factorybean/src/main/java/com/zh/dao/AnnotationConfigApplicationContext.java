package com.zh.dao;

import com.zh.anno.MyAnno;

import java.io.File;

/**
 * 模拟AnnotationConfigApplicationContext
 * @author he.zhang
 * @date 2020/2/28 10:57
 */
public class AnnotationConfigApplicationContext {

    /**
     * 模拟扫描包路径
     *
     * @param basePackage 根目录
     */
    public void scan(String basePackage){
        // 获取编译后的根目录，在项目编译后，只有class文件
        String rootPath = this.getClass().getResource("/").getPath();
        // 把传入的包路径，.换成\
        String basePackagePath = basePackage.replaceAll("\\.", "\\\\");
        // 获取文件路径的文件
        File file = new File(rootPath + "//" + basePackagePath);
        // 得到文件名数组
        String[] names = file.list();
        try {
            if(names != null && names.length > 0){
                for(String name : names){
                    // 把文件名后面的.class去掉，方便后面批接
                    name = name.replace(".class","");
                    Class clazz = Class.forName(basePackage + "." + name);
                    // 判断是否是属于@Service @.....注解，这里使用的是自定义注解
                    if (clazz.isAnnotationPresent(MyAnno.class)){
                        // 拿到注解，并输出注解值
                        MyAnno myAnno = (MyAnno) clazz.getAnnotation(MyAnno.class);
                        System.out.println(myAnno.value());
                        System.out.println(clazz.newInstance());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
