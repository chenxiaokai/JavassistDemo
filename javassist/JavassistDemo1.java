package com.example.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavassistDemo1 {

    public static void main(String[] args) throws Exception {
        //这个默认的ClassPool搜索系统路径，例如path和classpath路径
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.example.javassist.Hello");


        CtMethod method = cc.getDeclaredMethod("say");
        //在say() 方法第一行 添加 代码 $1 第一个参数， $2第二个参数
        method.insertBefore("{System.out.println($1); System.out.println($2);}");
        // $0 表示this指针
        method.insertAfter("{System.out.println($0);}");
        //将CtClass 转化为 Class对象
        Class clazz = cc.toClass();
        Hello h = (Hello) clazz.newInstance();
        h.say(1,3);

        //将字节码文件写在本地
        cc.writeFile();
    }
}
