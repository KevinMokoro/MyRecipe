package com.moringaschool.myrecipe;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRecipesAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mSources;
    private String[] mUrl;
    private String[] mImage;

    public MyRecipesAdapter(Context mContext, int resource, String[] mRecipes, String[] mSources, String[] mUrl, String[] mImage) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mSources = mSources;
        this.mUrl = mUrl;
        this.mImage = mImage;
    }
    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        String source = mSources[position];
        String url = mUrl[position];
        String image = mImage[position];
        return String.format("Recipe Name: %s \nSource: Person/Hotel %s: \nWebsite  %s  \n%s", recipe, source, url, image);
    }
    @Override
    public int getCount(){
        return mRecipes.length;
    }


}