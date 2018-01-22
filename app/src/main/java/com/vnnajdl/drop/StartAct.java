package com.vnnajdl.drop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Whatz on 22.01.2018.
 */

public class StartAct extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                mainAct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void mainAct(){
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
        finish();
    }
}
