package com.moringaschool.myrecipe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.SpoonacularRecipeSearchResponse;
import com.moringaschool.myrecipe.models.UsedIngredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter  extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private List<UsedIngredient> mRecipe;
    private Context mContext;

    public RecipeListAdapter(Context context, List<UsedIngredient> recipe) {
        mContext = context;
        mRecipe = recipe;

    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item,parent,false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipe.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }
    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mNameTextView;
        @BindView(R.id.sourceTextView) TextView mSourceTextView;
        @BindView(R.id.likesTextView) TextView mLikesTextView;

        private Context mContext;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRecipe(UsedIngredient recipe) {
            mNameTextView.setText(recipe.getOriginalName());
            mSourceTextView.setText(recipe.getId());
            mLikesTextView.setText(SpoonacularRecipeSearchResponse.getTitle().getLikes() + "Likes");
        }
    }
}
