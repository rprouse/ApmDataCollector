package com.bentley.apmdatacollector.model;

import android.support.annotation.NonNull;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Author: Rob.Prouse
 * Date: 2014-09-23.
 */
@DatabaseTable(tableName = "Checksheets")
public class Checksheet {
    public static final String C_ID = "id";
    public static final String C_TITLE = "title";
    public static final String C_CODE = "code";
    public static final String C_PERCENT = "percent";

    @DatabaseField(generatedId = true, canBeNull = false, columnName = C_ID)
    int _id;
    @DatabaseField(columnName = C_TITLE)
    String title;
    @DatabaseField(columnName = C_CODE)
    String code;
    @DatabaseField(columnName = C_PERCENT)
    int percent;
    @ForeignCollectionField(eager = true)
    ForeignCollection<Reading> readings;

    public Checksheet() {
    }

    public Checksheet(String title, String code, int percent) {
        this.title = title;
        this.code = code;
        this.percent = percent;
    }

    public ForeignCollection<Reading> getReadings() {
        return readings;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
