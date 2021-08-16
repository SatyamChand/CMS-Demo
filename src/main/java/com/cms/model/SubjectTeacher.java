package com.cms.model;

public class SubjectTeacher{
    private String name;
    private int teacher;

    public SubjectTeacher(String name, int teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "{ name:" + name + ", teacher:" + teacher + " }";
    }

}