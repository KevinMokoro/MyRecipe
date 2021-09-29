package com.moringaschool.myrecipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.myrecipe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.findRecipe) Button mFindRecipe;
    @BindView(R.id.aboutButton) Button mAboutButton;
    @BindView(R.id.savedRecipesButton) Button mSavedRecipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        mFindRecipe.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
        mSavedRecipesButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mFindRecipe) {

            Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
            startActivity(intent);
        }if(v == mSavedRecipesButton){
            Intent intent = new Intent(MainActivity.this, SavedRecipeListActivity.class);
            startActivity(intent);

        }
        else if(v == mAboutButton){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }





}