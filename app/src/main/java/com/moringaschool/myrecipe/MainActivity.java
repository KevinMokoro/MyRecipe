package com.moringaschool.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findRecipe) Button mFindRecipe;
    @BindView(R.id.editTextIngredient) EditText mEditTestIngredient;
    @BindView(R.id.aboutButton) Button mAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindRecipe.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mFindRecipe) {
            String ingredient = mEditTestIngredient.getText().toString();
            Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
            intent.putExtra("ingredient", ingredient);
            startActivity(intent);
        }else if(v == mAboutButton){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
        }

    }



}