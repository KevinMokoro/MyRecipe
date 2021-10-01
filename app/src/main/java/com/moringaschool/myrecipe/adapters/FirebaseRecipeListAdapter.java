package com.moringaschool.myrecipe.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.models.Hit;
import com.moringaschool.myrecipe.ui.RecipeDetailActivity;
import com.moringaschool.myrecipe.util.ItemTouchHelperAdapter;
import com.moringaschool.myrecipe.util.OnStartDragListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Hit, FirebaseRecipeViewHolder> implements ItemTouchHelperAdapter {
    private Query mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    private ChildEventListener mChildEventListener;
    private ArrayList<Hit> mRecipes = new ArrayList<>();




    public FirebaseRecipeListAdapter (FirebaseRecyclerOptions<Hit> options, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;



            mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mRecipes.add(dataSnapshot.getValue(Hit.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseRecipeViewHolder firebaseRecipeViewHolder, int position, @NonNull Hit recipe) {
        firebaseRecipeViewHolder.bindRecipe(recipe);
        firebaseRecipeViewHolder.mRecipeImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(firebaseRecipeViewHolder);
                }
                return false;
            }
        });


        firebaseRecipeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, RecipeDetailActivity.class);
            intent.putExtra("position", firebaseRecipeViewHolder.getAdapterPosition());
            intent.putExtra("recipes", Parcels.wrap(mRecipes));
            mContext.startActivity(intent);
        }
    });
}


    @NonNull
    @Override
    public FirebaseRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_drag, parent, false);
        return new FirebaseRecipeViewHolder(view);
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        Collections.swap(mRecipes, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }



    private void setIndexInFirebase() {
        for (Hit recipe : mRecipes) {
            int index = mRecipes.indexOf(recipe);
            DatabaseReference  mReference  = getRef(index);
            recipe.setIndex(Integer.toString(index));
            mReference.setValue(recipe);
        }
    }

    @Override
    public void onItemDismiss(int position){
        mRecipes.remove(position);
        getRef(position).removeValue();
    }




    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }


}