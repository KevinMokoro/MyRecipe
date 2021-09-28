package com.moringaschool.myrecipe.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.myrecipe.Constants;
import com.moringaschool.myrecipe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @BindView(R.id.findRecipe) Button mFindRecipe;
    @BindView(R.id.editTextIngredient) EditText mEditTestIngredient;
    @BindView(R.id.aboutButton) Button mAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();


        mFindRecipe.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mFindRecipe) {
            String ingredient = mEditTestIngredient.getText().toString();
            if(!(ingredient).equals("")) {
                addToSharedPreferences(ingredient);
            }
            Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
            intent.putExtra("ingredient", ingredient);
            startActivity(intent);
        }else if(v == mAboutButton){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
        }

    }
    private void addToSharedPreferences(String ingredient) {
        mEditor.putString(Constants.PREFERENCES_INGREDIENT_KEY, ingredient).apply();
    }




}