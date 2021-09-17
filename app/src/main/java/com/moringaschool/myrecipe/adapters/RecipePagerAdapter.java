package com.moringaschool.myrecipe.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.myrecipe.ui.RecipeDetailFragment;

public class RecipePagerAdapter extends FragmentPagerAdapter {

    private List<Recipes> mRecipes;

    public RecipePagerAdapter (@NonNull FragmentManager fm, int behavior, List<Recipes> recipes) {
        super(fm, behavior);
        mRecipes = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount (){
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mRecipes.get(position).getName();
    }


}
