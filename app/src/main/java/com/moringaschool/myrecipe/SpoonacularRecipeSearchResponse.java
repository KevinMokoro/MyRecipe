
package com.moringaschool.myrecipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SpoonacularRecipeSearchResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageType")
    @Expose
    private String imageType;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("missedIngredientCount")
    @Expose
    private Integer missedIngredientCount;
    @SerializedName("missedIngredients")
    @Expose
    private List<MissedIngredient> missedIngredients = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("unusedIngredients")
    @Expose
    private List<UnusedIngredient> unusedIngredients = null;
    @SerializedName("usedIngredientCount")
    @Expose
    private Integer usedIngredientCount;
    @SerializedName("usedIngredients")
    @Expose
    private List<UsedIngredient> usedIngredients = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SpoonacularRecipeSearchResponse() {
    }

    /**
     * 
     * @param image
     * @param usedIngredients
     * @param missedIngredients
     * @param missedIngredientCount
     * @param unusedIngredients
     * @param id
     * @param title
     * @param imageType
     * @param likes
     * @param usedIngredientCount
     */
    public SpoonacularRecipeSearchResponse(Integer id, String image, String imageType, Integer likes, Integer missedIngredientCount, List<MissedIngredient> missedIngredients, String title, List<UnusedIngredient> unusedIngredients, Integer usedIngredientCount, List<UsedIngredient> usedIngredients) {
        super();
        this.id = id;
        this.image = image;
        this.imageType = imageType;
        this.likes = likes;
        this.missedIngredientCount = missedIngredientCount;
        this.missedIngredients = missedIngredients;
        this.title = title;
        this.unusedIngredients = unusedIngredients;
        this.usedIngredientCount = usedIngredientCount;
        this.usedIngredients = usedIngredients;
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

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(Integer missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public List<MissedIngredient> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<MissedIngredient> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UnusedIngredient> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<UnusedIngredient> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }

    public Integer getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(Integer usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public List<UsedIngredient> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<UsedIngredient> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

}
