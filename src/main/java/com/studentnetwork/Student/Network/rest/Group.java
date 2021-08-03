package com.studentnetwork.Student.Network.rest;

public class Group {


    private String subject;
    private String faculty;
    private String university;

    public Group(){

    }
    public Group(String subject, String faculty, String university) {

        this.subject = subject;
        this.faculty = faculty;
        this.university = university;
    }





    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
