package com.example.javassist;


import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

//遍历方法中的所有方法调用
public class JavassistDemo4 {

    public static void main(String[] args) throws Exception{
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.example.javassist.Point");
        CtMethod ctMethod = ctClass.getDeclaredMethod("move");
        ctMethod.instrument(new ExprEditor(){
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                super.edit(m);
                //这里得到 move方法中的所有方法的调用
                System.out.println(m.getClassName()+"      "+m.getMethodName());
            }
        });
    }

}
