package com.pojo;

import java.io.Serializable;

public class order implements Serializable {

    private int id;
    private long number;
    private int userid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", number=" + number +
                ", userid=" + userid +
                '}';
    }
}
