package com.cms.document;

import java.util.List;

import com.cms.model.SubjectTeacher;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "section")
public class Section {

    @Id
    private String id;
    private int head;
    private String course;
    private List<SubjectTeacher> subject;
    
    public Section(String id, int head, String course, List<SubjectTeacher> subject) {
        this.id = id;
        this.head = head;
        this.course = course;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<SubjectTeacher> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectTeacher> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{ name:" + id + ", course: " + course + ", head:" + head + ", subject=" + subject + " }";
    }    

}
