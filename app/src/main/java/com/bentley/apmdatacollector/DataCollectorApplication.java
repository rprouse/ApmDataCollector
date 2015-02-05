package com.bentley.apmdatacollector;

import android.app.Application;

import com.bentley.apmdatacollector.database.DatabaseManager;
import com.bentley.apmdatacollector.model.Checksheet;

import java.util.List;

/**
 * Author: Rob.Prouse
 * Date: 2014-09-23.
 */
public class DataCollectorApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);

        List<Checksheet> checksheets = DatabaseManager.getInstance().getAllChecksheets();
    }
}
