package com.studentnetwork.Student.Network.database;


import javax.persistence.*;

@Entity
@Table(name = "Post")
public class PostDB {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idPost;
    private int userId;
    private String text;
    private int groupId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
