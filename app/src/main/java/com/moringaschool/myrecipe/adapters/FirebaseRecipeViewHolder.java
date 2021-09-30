package com.moringaschool.myrecipe.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.Hit;
import com.squareup.picasso.Picasso;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder {
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
      //  TextView sourceTextView = mView.findViewById(R.id.sourceNameTextView);

        Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);

        nameTextView.setText(recipe.getRecipe().getLabel());

        //sourceTextView.setText(recipe.getRecipe().getSource());

    }

}
