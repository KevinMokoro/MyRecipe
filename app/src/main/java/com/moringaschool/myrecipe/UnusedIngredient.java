
package com.moringaschool.myrecipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UnusedIngredient {

    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("meta")
    @Expose
    private List<Object> meta = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original")
    @Expose
    private String original;
    @SerializedName("originalName")
    @Expose
    private String originalName;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("unitLong")
    @Expose
    private String unitLong;
    @SerializedName("unitShort")
    @Expose
    private String unitShort;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnusedIngredient() {
    }

    /**
     * 
     * @param originalName
     * @param image
     * @param amount
     * @param unit
     * @param original
     * @param unitShort
     * @param meta
     * @param name
     * @param unitLong
     * @param id
     * @param aisle
     */
    public UnusedIngredient(String aisle, Double amount, Integer id, String image, List<Object> meta, String name, String original, String originalName, String unit, String unitLong, String unitShort) {
        super();
        this.aisle = aisle;
        this.amount = amount;
        this.id = id;
        this.image = image;
        this.meta = meta;
        this.name = name;
        this.original = original;
        this.originalName = originalName;
        this.unit = unit;
        this.unitLong = unitLong;
        this.unitShort = unitShort;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

}
