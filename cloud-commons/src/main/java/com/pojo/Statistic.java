package com.pojo;

import java.io.Serializable;

public class Statistic implements Serializable {


    private long id;
    private long articleid;
    private int hit;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleid() {
        return articleid;
    }

    public void setArticleid(long articleid) {
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
