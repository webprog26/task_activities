package com.example.webprog26.taskactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ActivityStarter{

    private static final String LOG_TAG = "MainActivity_TAG";

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " created");

        Button btnStartBlueButtonActivity = (Button) findViewById(R.id.btnStartBlueButtonActivity);
        Button btnStartRedButtonActivity = (Button) findViewById(R.id.btnStartRedButtonActivity);

        btnStartBlueButtonActivity.setOnClickListener(this);
        btnStartRedButtonActivity.setOnClickListener(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar(mToolbar);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId())
        {
            case R.id.btnStartBlueButtonActivity:
                intent = new Intent(this, BlueButtonActivity.class);
                startSecondPartActivity(this, intent);
                break;
            case R.id.btnStartRedButtonActivity:
                intent = new Intent(this, RedButtonActivity.class);
                startSecondPartActivity(this, intent);
                break;
        }
    }

    /**
     * Starts new second part Activity targeted by intent
     * @param activity
     * @param intent
     */
    @Override
    public void startSecondPartActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }

    /**
     * Initializes toolbar
     * @param toolbar
     */
    private void initToolbar(Toolbar toolbar)
    {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        setToolBarTitle(actionBar, this.getClass().getSimpleName());
    }


    /**
     * Sets actionBar title
     * @param actionBar
     * @param toolBarTitle
     */
    @Override
    public void setToolBarTitle(ActionBar actionBar, String toolBarTitle) {
        actionBar.setTitle(toolBarTitle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " destroyed");
    }
}
