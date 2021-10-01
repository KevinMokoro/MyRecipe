package com.moringaschool.myrecipe.adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.Hit;
import com.moringaschool.myrecipe.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    View mView;
    Context mContext;

    public ImageView mRecipeImageView;

    public FirebaseRecipeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();

    }



    public void bindRecipe(Hit recipe) {
        mRecipeImageView = mView.findViewById(R.id.recipeImageView);
        TextView nameTextView = mView.findViewById(R.id.recipeNameTextView);
        TextView sourceTextView = mView.findViewById(R.id.sourceNameTextView);

        Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);

        nameTextView.setText(recipe.getRecipe().getLabel());

        sourceTextView.setText(recipe.getRecipe().getSource());

    }




    @Override
    public void onItemSelected() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
               R.animator.drag_scale_on);
       set.setTarget(itemView);
       set.start();
   }

    @Override
    public void onItemClear() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }

}
