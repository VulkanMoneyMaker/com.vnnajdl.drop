package com.vnnajdl.drop;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vnnajdl.drop.model.CarType;
import com.vnnajdl.drop.model.MeetData;
import com.vnnajdl.drop.model.SmokingType;
import com.vnnajdl.drop.user_data.src.kankan.profile.items.OnWheelScrollListener;
import com.vnnajdl.drop.user_data.src.kankan.profile.items.WheelView;

import java.util.ArrayList;
import java.util.Random;



public class ActivityForGame extends AppCompatActivity implements OnWheelScrollListener {

    private static final String TAG = ActivityForGame.class.getSimpleName();

    private ItemsPlay itemsPlay = new ItemsPlay();
    private ArrayList<Integer> listForItemsPlay;

    private CarType carType;
    private MeetData meetData;
    private SmokingType smokingType;


    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    protected void setHomeAsUpIndicator(int resId) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    protected void hideActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public ActivityForGame() {
        super();
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        return super.supportRequestWindowFeature(featureId);
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        itemsPlay.view1 = findViewById(R.id.wheel1);
        itemsPlay.view2 = findViewById(R.id.wheel2);
        itemsPlay.view3 = findViewById(R.id.wheel3);
        itemsPlay.view4 = findViewById(R.id.wheel4);
        itemsPlay.view5 = findViewById(R.id.wheel5);

        playData();
        Button playBtn = findViewById(R.id.btn_play);
        playBtn.setOnClickListener(arg -> createMediaDataItems());

        carType = new CarType() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };


        meetData = new MeetData();
        meetData.city = "play";

        smokingType = new SmokingType() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

    }

    private void playData() {

        if (meetData != null && meetData.numFlat > 100000) {
            hideActionBar();
            setDisplayHomeAsUpEnabled(true);
            setHomeAsUpIndicator(1);
        }

        initPlayerData(itemsPlay.view1, getListForItemsPlay());
        initPlayerData(itemsPlay.view2, getListForItemsPlay());
        initPlayerData(itemsPlay.view3, getListForItemsPlay());
        initPlayerData(itemsPlay.view4, getListForItemsPlay());
        initPlayerData(itemsPlay.view5, getListForItemsPlay());
    }

    private ArrayList<Integer> getListForItemsPlay(){

        if (meetData != null && meetData.city != null && meetData.city.equals("new_play")) {
            return new ArrayList<>();
        }

        if (listForItemsPlay == null) {
            final ArrayList<Integer> list = new ArrayList<>();
            list.add(R.drawable.item_1);
            list.add(R.drawable.item_2);
            list.add(R.drawable.item_3);
            list.add(R.drawable.item_4);
            list.add(R.drawable.item_5);
            list.add(R.drawable.item_6);
            list.add(R.drawable.item_7);
            list.add(R.drawable.item_8);
            list.add(R.drawable.item_9);
            this.listForItemsPlay = list;
        }

        return listForItemsPlay;
    }

    private void initPlayerData(WheelView wheelView, ArrayList<Integer> list) {
        wheelView.setViewAdapter(new AdapterForGameItems(this, list));
        wheelView.setCurrentItem((int) (Math.random() * 10.0d));
        wheelView.setVisibleItems(4);
        wheelView.setCyclic(true);
        wheelView.setEnabled(false);
    }

    @Override
    public void onStart(){
        Log.d(TAG, "onStart");

        super.onStart();
    }

    @Override
    public void onStop(){
        Log.d(TAG, "onStop");

        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.d(TAG, "onDestroy");

        super.onDestroy();
    }


    private void createMediaDataItems() {
        Random random = new Random();
        itemsPlay.view1.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view2.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view3.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view4.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view5.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
    }

    private class ItemsPlay {

        WheelView view1;
        WheelView view2;
        WheelView view3;
        WheelView view4;
        WheelView view5;
    }


    @Override
    public void onScrollingStarted(WheelView wheel) {

    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
        Log.d("onScrollingFinished: ", String.valueOf(wheel.getCurrentItem()));
    }

//    @Override
//    public void onBackPressed() {
//        System.exit(0);
//    }
}
