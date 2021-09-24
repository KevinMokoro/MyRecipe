package com.moringaschool.myrecipe.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.Hit;
import com.moringaschool.myrecipe.ui.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter  extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private List<Hit> mRecipe;
    private Context mContext;

    public RecipeListAdapter(Context context, List<Hit> recipe) {
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
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipe.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mNameTextView;
      //  @BindView(R.id.sourceTextView) TextView mSourceTextView;
     //   @BindView(R.id.likesTextView) TextView mLikesTextView;

    //    private Context mContext;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindRecipe(Hit recipe) {

            Picasso.get().load(recipe.getRecipe().getImage()).into(mRecipeImageView);
            mNameTextView.setText(recipe.getRecipe().getLabel());
       //     mSourceTextView.setText(recipe.getRecipe().getSource());
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailActivity.class);
            intent.putExtra("position",itemPosition);
            intent.putExtra("recipes", Parcels.wrap(mRecipe));
            mContext.startActivity(intent);

        }
    }
}
