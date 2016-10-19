package com.example.webprog26.taskactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

/**
 * Created by webprog26 on 19.10.2016.
 */

public interface ActivityStarter {
    /**
     * Starts new second part Activity targeted by intent
     * @param activity
     * @param intent
     */
    void startSecondPartActivity(Activity activity, Intent intent);

    /**
     * Sets actionBar title
     * @param actionBar
     * @param toolBarTitle
     */
    void setToolBarTitle(ActionBar actionBar, String toolBarTitle);
}
