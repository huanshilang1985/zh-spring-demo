package com.zh.proxy3;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态代理工具类-模拟
 */
public class ProxyUtil {

    /**
     * 实现步骤：
     * 先要确定内容content，content实质是String
     * <p>
     * 1. 获得.java文件，通过IO创建
     * <p>
     * 2. 得到.class文件
     * <p>
     * <p>
     * 3. 得到new对象
     * <p>
     * Object target 是目标对象
     *
     * @return
     */
    public static Object newInstance(Object target) {
        Object proxy = null;
        // 取目标对象的接口
        Class<?> targetInf = target.getClass().getInterfaces()[0];

        String line = "\n";
        String tab = "\t";
        // 目标对象名称
        String infName = targetInf.getSimpleName();
        // 目标对象的所有方法
        Method[] methods = targetInf.getDeclaredMethods();

        String context = "";
        // 包名
        String packageContext = "package com.google" + line;
        // 导入信息
        String importContext = "import " + targetInf.getName() + ";" + line;
        // 类的第一行
        String classFirstLineContext = "public class $Proxy implements " + infName + "{" + line;
        // 引入属性
        String fieldContext = tab + "private " + infName + " target" + line;
        // 构造方法
        String constructorContext = tab + "public $Proxy (" + infName + " target){" + line
                + tab + tab + "this.target = target;" + line
                + tab + "}" + line;

        String methodContext = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName(); // 方法返回值
            String methodName = method.getName();
            Object args[] = method.getParameterTypes();  // 参数类型
            String argsContext = ""; // 参数信息
            String paramsContenct = "";  // 参数变量名信息
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                String temp = arg.getClass().getSimpleName();
                argsContext += temp + " p" + i + ",";
                paramsContenct += "p" + i + ",";
            }
            if (argsContext.length() > 0) {
                argsContext = argsContext.substring(0, argsContext.length() - 1);
                paramsContenct = paramsContenct.substring(0, paramsContenct.length() - 1);
            }

            methodContext += tab + "public " + returnTypeName + " " + methodName + "(" + argsContext + "){" + line
                    + tab + tab + "System.out.println(\"log\");" + line
                    + tab + tab + "target." + methodName + "(" + paramsContenct + ");" + line
                    + tab + "}" + line;
        }

        context = packageContext + importContext + classFirstLineContext + fieldContext + constructorContext + methodContext + "}";

        System.out.println(context);

        try {
            File file = new File("d:\\app\\$Proxy.java");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(context);
            writer.flush();
            writer.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");

            // 获取构造对象
            Constructor constructor = clazz.getConstructor(targetInf);
            proxy = constructor.newInstance(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }

    public static void main(String[] args) {

    }

}
