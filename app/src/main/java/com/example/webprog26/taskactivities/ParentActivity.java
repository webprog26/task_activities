package com.example.webprog26.taskactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by webprog26 on 19.10.2016.
 */

public abstract class ParentActivity extends AppCompatActivity implements View.OnClickListener, ActivityStarter {

    /**
     * Provides different Res.id for activities
     *
     * @return view resId
     */
    protected abstract int getContentViewResId();

    /**
     * Initializes return to MainActivity button
     * @return button
     */
    protected abstract Button getButton();

    /**
     * Initializes Toolbar with Activity title
     * @return toolbar
     */
    protected abstract Toolbar getToolbar();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getContentViewResId() == 0) return;
        setContentView(getContentViewResId());

        Log.i(getTag(), getTag() + " created");

        if(getButton() == null || getToolbar() == null) return;

        Button button = getButton();
        button.setOnClickListener(this);

        Toolbar toolbar = getToolbar();
        initToolbar(toolbar);
    }

    /**
     * Initializes toolbar
     * @param toolbar
     */
    protected void initToolbar(Toolbar toolbar)
    {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        setToolBarTitle(actionBar, this.getClass().getSimpleName());
    }

    /**
     * Starts new second part Activity targeted by intent
     *
     * @param activity
     * @param intent
     */
    @Override
    public void startSecondPartActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
        finish();
    }

    /**
     * Sets actionBar title
     *
     * @param actionBar
     * @param toolBarTitle
     */
    @Override
    public void setToolBarTitle(ActionBar actionBar, String toolBarTitle) {
        actionBar.setTitle(toolBarTitle);
    }

    /**
     * Creates TAG for logging activity's lifecycle
     * @return tag
     */
    protected String getTag()
    {
        return this.getClass().getSimpleName() + "_TAG";
    }

    /**
     * Dispatch onStart() to all fragments.  Ensure any created loaders are
     * now started.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getTag(), getTag() + " started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getTag(), getTag() + " resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getTag(), getTag() + " paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(getTag(), getTag() + " restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getTag(), getTag() + " destroyed");
    }
}
