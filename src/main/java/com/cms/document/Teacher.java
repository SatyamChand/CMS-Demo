package com.cms.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
    
    @Id
    private int id;
    private String name;
    private String sectionHead;
    private List<String> allotedSections;
    private String subject;

    
    public Teacher(int id, String name, String sectionHead, ArrayList<String> allotedSections, String subject) {
        this.id = id;
        this.name = name;
        this.sectionHead = sectionHead;
        this.allotedSections = allotedSections;
        this.subject = subject;
    }

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSectionHead() {
        return sectionHead;
    }


    public void setSectionHead(String sectionHead) {
        this.sectionHead = sectionHead;
    }


    public List<String> getAllotedSections() {
        return allotedSections;
    }


    public void setAllotedSections(List<String> allotedSections) {
        this.allotedSections = allotedSections;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "{ id: "+ id +", name: "+ name+ ", sectionHead: "+ sectionHead +", allotedSections: "+ allotedSections +", subject: "+ subject +" }";
    }

    
    
}
