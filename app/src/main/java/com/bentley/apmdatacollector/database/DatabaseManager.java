package com.bentley.apmdatacollector.database;

import android.content.Context;

import com.bentley.apmdatacollector.model.Checksheet;
import com.bentley.apmdatacollector.model.Reading;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Rob.Prouse
 * Date: 2014-09-23.
 */
public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    /******* CRUD functions ******/

    /**
     * Adds a Checksheet
     */
    public void addChecksheet(Checksheet checksheet) {
        try {
            getHelper().getChecksheetDao().create(checksheet);
            for(Reading reading : checksheet.getReadings()) {
                getHelper().getReadingDao().create(reading);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all data from Checksheets table
     *
     * @return List of Checksheet
     */
    public List<Checksheet> getAllChecksheets() {
        List<Checksheet> checksheets = null;
        try {
            checksheets = getHelper().getChecksheetDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checksheets;
    }

    /**
     * Deletes a Checksheet
     *
     * @param checksheetId        ID (primary key) of Checksheet
     */
    public void deleteChecksheet(int checksheetId) {
        try {
            DeleteBuilder<Reading, Integer> deleteBuilder = getHelper().getReadingDao().deleteBuilder();
            deleteBuilder.where().eq(Reading.C_CHECKSHEET_ID, checksheetId);
            deleteBuilder.delete();
            getHelper().getChecksheetDao().deleteById(checksheetId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a Checksheet
     *
     * @param checksheet    Checksheet
     */
    public void updateChecksheet(Checksheet checksheet) {
        try {
            getHelper().getChecksheetDao().update(checksheet);
            for(Reading reading : checksheet.getReadings()) {
                getHelper().getReadingDao().update(reading);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a Reading
     *
     * @param reading    Reading
     */
    public void updateReading(Reading reading) {
        try {
            getHelper().getReadingDao().update(reading);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
