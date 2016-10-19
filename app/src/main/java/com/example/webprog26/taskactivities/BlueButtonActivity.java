package com.example.webprog26.taskactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class BlueButtonActivity extends ParentActivity {

    //NOTE! Use BlueButtonActivity_TAG to see logs of activity's lifecycle

    /**
     * Initializes return to MainActivity button
     * @return button
     */
    @Override
    protected Button getButton() {
        return (Button) findViewById(R.id.btnReturnToMainActivity);
    }

    /**
     * Provides different Res.id for activities
     *
     * @return view resId
     */
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_blue_button;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startSecondPartActivity(this, intent);
    }

    /**
     * Starts new second part Activity targeted by intent
     *
     * @param activity
     * @param intent
     */
    @Override
    public void startSecondPartActivity(Activity activity, Intent intent) {
        super.startSecondPartActivity(activity, intent);
    }

    @Override
    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    /**
     * Initializes toolbar
     *
     * @param toolbar
     */
    @Override
    protected void initToolbar(Toolbar toolbar) {
        super.initToolbar(toolbar);
    }

    /**
     * Creates TAG for logging activity's lifecycle
     * @return tag
     */
    @Override
    protected String getTag() {
        return super.getTag();
    }
}
