package com.epam.jamp.multithreading.seven;

public class MyObject {

    private Integer number;
    private String name;

    public MyObject(Integer number, String name) {
        this.name = name;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
