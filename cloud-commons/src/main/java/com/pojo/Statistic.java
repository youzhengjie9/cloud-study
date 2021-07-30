package com.pojo;

import java.io.Serializable;

public class Statistic implements Serializable {


    private int id;
    private int articleid;
    private int hit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", articleid=" + articleid +
                ", hit=" + hit +
                '}';
    }
}
