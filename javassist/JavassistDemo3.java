package com.example.javassist;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

public class JavassistDemo3 {

    public static void main(String[] args) throws Exception{
        ClassPool pool = ClassPool.getDefault();
        //创建一个类，父类是TestBean抽象类
        CtClass ctClass = pool.makeClass("MyBean",pool.get("com.example.javassist.TestBean"));
        // 返回类型，方法名，方法参数，方法属于哪个类
        CtMethod method1 = new CtMethod(pool.get("java.lang.String"),"getM",null,ctClass);
        method1.setBody("{return \"你好\";}");
        ctClass.addMethod(method1);

        CtMethod method2 = new CtMethod(CtClass.voidType,"setF",new CtClass[]{pool.get("java.lang.String")},ctClass);
        //$1 为方法第一个参数
        method2.setBody("{this.field = $1;}");
        ctClass.addMethod(method2);

        //参数，构造方法在哪个类
        CtConstructor cc = new CtConstructor(null,ctClass);
        cc.setBody("{this.field=\"why?\";}");
        ctClass.addConstructor(cc);

        Class<?> c = ctClass.toClass();
        TestBean bean = (TestBean) c.newInstance();

        System.out.println(bean.getM());
        System.out.println(bean.getF());
        bean.setF("setF");
        System.out.println(bean.getF());

    }

}
