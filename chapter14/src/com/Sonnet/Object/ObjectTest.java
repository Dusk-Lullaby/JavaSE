package com.Sonnet.Object;

public class ObjectTest {

    public static void main(String[] args) {
        TV tv = new TV();
        //获取TV的信息
        Class clazz = tv.getClass();
        //获取类名
        String name = clazz.getSimpleName();
        System.out.println(name);
        //获取类的全限定名(包名 + 类名)
        String className = clazz.getName();
        System.out.println(className);
        //获取父类的定义信息
        Class superClass = clazz.getSuperclass();
        //获取父类的名称
        String superName = clazz.getSuperclass().getSimpleName();
        String superName2 = superClass.getSimpleName();
        System.out.println(superName);
        System.out.println(superName2);
        //获取父类的全限定名
        String superClassName = clazz.getSuperclass().getName();
        String superClassName2 = superClass.getName();
        System.out.println(superClassName);
        System.out.println(superClassName2);

        //String类
        String s = "admin";
        //获取String类的信息
        Class StringClass = s.getClass();
        //获取String类的接口，因为接口有多个所以需要数组
        Class[] interfaceClasses = StringClass.getInterfaces();
        //打印
        for (int i = 0; i < interfaceClasses.length; i++) {
            //获取接口信息
            Class interfaceClass = interfaceClasses[i];
            //获取接口名字
            String interfaceName = interfaceClass.getSimpleName();
            System.out.println(interfaceName);
            //获取接口全限定名
            String interfaceClassName = interfaceClass.getName();
            System.out.println(interfaceClassName);
        }
    }
}
