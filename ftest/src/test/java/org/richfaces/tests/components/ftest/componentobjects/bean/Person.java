package org.richfaces.tests.components.ftest.componentobjects.bean;

public class Person {

    private String firstName;
    private String surnameName;
    private Integer age;
    private String address;
    private String phone;

    public Person(String firstName, String surnameName, Integer age,
            String address, String phone) {
        super();
        this.firstName = firstName;
        this.surnameName = surnameName;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurnameName() {
        return surnameName;
    }

    public void setSurnameName(String surnameName) {
        this.surnameName = surnameName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}