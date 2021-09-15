
package com.moringaschool.myrecipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Self__1 {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Self__1() {
    }

    /**
     * 
     * @param href
     * @param title
     */
    public Self__1(String href, String title) {
        super();
        this.href = href;
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}