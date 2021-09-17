package com.moringaschool.myrecipe;



import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeObject {
    @SerializedName("from")
    private int from;
    @SerializedName("to")
    private int to;
    @SerializedName("count")
    private int count;
    @Nullable
    @SerializedName("hits")
    private List<Hits> hits;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Nullable
    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(@Nullable List<Hits> hits) {
        this.hits = hits;
    }

    class Links1 {
        @Nullable
        @SerializedName("next")
        private Next next;
    }

    class Next {
        @Nullable
        @SerializedName("href")
        private String href;
        @Nullable
        @SerializedName("title")
        private String title;
    }

    class Hits {
        @Nullable
        @SerializedName("recipe")
        private Recipe recipe;
        @Nullable
        @SerializedName("_links")
        private Links2 Links;

        @Nullable
        public Recipe getRecipe() {
            return recipe;
        }

        public void setRecipe(@Nullable Recipe recipe) {
            this.recipe = recipe;
        }

        @Nullable
        public Links2 getLinks() {
            return Links;
        }

        public void setLinks(@Nullable Links2 links) {
            Links = links;
        }
    }

    class Recipe {
        @Nullable
        @SerializedName("uri")
        private String uri;
        @Nullable
        @SerializedName("label")
        private String label;
        @Nullable
        @SerializedName("image")
        private String image;
        @Nullable
        @SerializedName("source")
        private String source;
        @Nullable
        @SerializedName("url")
        private String url;
        @Nullable
        @SerializedName("shareAs")
        private String shareAs;
        @SerializedName("yield")
        private double yield0;
        @Nullable
        @SerializedName("dietLabels")
        private List<String> dietLabels;
        @Nullable
        @SerializedName("healthLabels")
        private List<String> healthLabels;
        @Nullable
        @SerializedName("cautions")
        private List<String> cautions;
        @Nullable
        @SerializedName("ingredientLines")
        private List<String> ingredientLines;
        @Nullable
        @SerializedName("ingredients")
        private List<Ingredients> ingredients;
        @SerializedName("calories")
        private double calories;
        @SerializedName("totalWeight")
        private double totalWeight;
        @SerializedName("totalTime")
        private double totalTime;
        @Nullable
        @SerializedName("cuisineType")
        private List<String> cuisineType;
        @Nullable
        @SerializedName("mealType")
        private List<String> mealType;
        @Nullable
        @SerializedName("dishType")
        private List<String> dishType;
        @Nullable
        @SerializedName("digest")
        private List<Digest> digest;

        @Nullable
        public String getUri() {
            return uri;
        }

        public void setUri(@Nullable String uri) {
            this.uri = uri;
        }

        @Nullable
        public String getLabel() {
            return label;
        }

        public void setLabel(@Nullable String label) {
            this.label = label;
        }

        @Nullable
        public String getImage() {
            return image;
        }

        public void setImage(@Nullable String image) {
            this.image = image;
        }

        @Nullable
        public String getSource() {
            return source;
        }

        public void setSource(@Nullable String source) {
            this.source = source;
        }

        @Nullable
        public String getUrl() {
            return url;
        }

        public void setUrl(@Nullable String url) {
            this.url = url;
        }

        @Nullable
        public List<String> getIngredientLines() {
            return ingredientLines;
        }

        public void setIngredientLines(@Nullable List<String> ingredientLines) {
            this.ingredientLines = ingredientLines;
        }

        @Nullable
        public List<Ingredients> getIngredients() {
            return ingredients;
        }

        public void setIngredients(@Nullable List<Ingredients> ingredients) {
            this.ingredients = ingredients;
        }
    }

    class Ingredients {
        @Nullable
        @SerializedName("text")
        private String text;
        @SerializedName("quantity")
        private double quantity;
        @Nullable
        @SerializedName("measure")
        private String measure;
        @Nullable
        @SerializedName("food")
        private String food;
        @SerializedName("weight")
        private double weight;
        @Nullable
        @SerializedName("foodCategory")
        private String foodCategory;
        @Nullable
        @SerializedName("foodId")
        private String foodId;
        @Nullable
        @SerializedName("image")
        private String image;
    }
    class Digest {
        @Nullable
        @SerializedName("label")
        private String label;
        @Nullable
        @SerializedName("tag")
        private String tag;
        @Nullable
        @SerializedName("schemaOrgTag")
        private String schemaOrgTag;
        @SerializedName("total")
        private double total;
        @SerializedName("hasRDI")
        private boolean hasRDI;
        @SerializedName("daily")
        private double daily;
        @Nullable
        @SerializedName("unit")
        private String unit;
        @Nullable
        @SerializedName("sub")
        private List<Sub> sub;
    }

    class Sub {
        @Nullable
        @SerializedName("label")
        private String label;
        @Nullable
        @SerializedName("tag")
        private String tag;
        @Nullable
        @SerializedName("schemaOrgTag")
        private String schemaOrgTag;
        @SerializedName("total")
        private double total;
        @SerializedName("hasRDI")
        private boolean hasRDI;
        @SerializedName("daily")
        private double daily;
        @Nullable
        @SerializedName("unit")
        private String unit;
    }

    class Links2 {
        @Nullable
        @SerializedName("self")
        private Self self;
    }

    class Self {
        @Nullable
        @SerializedName("href")
        private String href;
        @Nullable
        @SerializedName("title")
        private String title;
    }
}

