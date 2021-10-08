package com.studentnetwork.Student.Network.database;

import javax.persistence.*;


public class GroupDB {



    private int groupDbId;
    private String groupDbName;


    public int getGroupDbId() {
        return groupDbId;
    }

    public void setGroupDbId(int groupId) {
        this.groupDbId = groupId;
    }

    public String getGroupName() {
        return groupDbName;
    }

    public void setGroupName(String groupName) {
        this.groupDbName = groupName;
    }
}
