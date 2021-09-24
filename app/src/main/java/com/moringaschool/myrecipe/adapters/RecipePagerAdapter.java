package com.moringaschool.myrecipe.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.myrecipe.models.Hit;
import com.moringaschool.myrecipe.ui.RecipeDetailFragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {

    private List<Hit> mRecipes;

    public RecipePagerAdapter (@NonNull FragmentManager fm, int behavior, List<Hit> recipes) {
        super(fm, behavior);
        mRecipes = recipes;
    }

    @Override
    public RecipeDetailFragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount (){
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mRecipes.get(position).getRecipe().getLabel();
    }


}
