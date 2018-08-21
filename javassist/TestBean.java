package com.example.javassist;

public abstract class TestBean {

    public String field;

    public abstract String getM();

    public abstract void setF(String f);

    public String getF() {
        return this.field;
    }

}
