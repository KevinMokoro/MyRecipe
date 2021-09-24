package com.moringaschool.myrecipe.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.Hit;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeDetailFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.recipeImageView) ImageView mImageLabel;
    @BindView(R.id.recipeNameTextView) TextView mNameLabel;
 //   @BindView(R.id.sourceTextView) TextView mSourceLabel;
 //   @BindView(R.id.likesTextView) TextView mLikesLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
   // @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveRecipeButton) TextView mSaveRecipeButton;


    private Hit mRecipe;

    public RecipeDetailFragment() {
        // Required empty public constructor
    }


    public static RecipeDetailFragment newInstance(Hit recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mRecipe.getRecipe().getImage()).into(mImageLabel);

   //     List<String> categories = new ArrayList<>();
    //    List<String> sources = new ArrayList<>();
    //    String sources = mRecipe.getRecipe().getSource();
    //    List<String> sources = new ArrayList<>();

   //     for (RecipeObject.Hits source: mRecipe.getRecipe().getSource()) {
     //       sources.add(source.getTitle());
  //      }

   //     for (Category category: mRestaurant.getCategories()) {
    //        categories.add(category.getTitle());
   //     }

        mNameLabel.setText(mRecipe.getRecipe().getLabel());
    //    mSourceLabel.setText(android.text.TextUtils.join(", ", sources));
     //   mLikesLabel.setText(Double.toString(mRestaurant.getRating()) + "/5");
      //  mPhoneLabel.setText(mRestaurant.getPhone());
      //  mAddressLabel.setText(mRestaurant.getLocation().toString());

        mWebsiteLabel.setOnClickListener(this);
     //   mPhoneLabel.setOnClickListener(this);
    //    mAddressLabel.setOnClickListener(this);



        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getRecipe().getUrl()));
            startActivity(webIntent);
        }
    //    if (v == mPhoneLabel) {
    //        Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
   //                 Uri.parse("tel:" + mRestaurant.getPhone()));
    //        startActivity(phoneIntent);
     //   }
     //   if (v == mAddressLabel) {
     //       Intent mapIntent = new Intent(Intent.ACTION_VIEW,
     //               Uri.parse("geo:" + mRecipe.getCoordinates().getLatitude()
     //                       + "," + mRecipe.getCoordinates().getLongitude()
    //                        + "?q=(" + mRecipe.getName() + ")"));
     //       startActivity(mapIntent);
        }
    }





