package com.bentley.apmdatacollector.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Author: Rob.Prouse
 * Date: 2014-09-23.
 */
@DatabaseTable(tableName = "Readings")
public class Reading {
    public static final String C_ID = "id";
    public static final String C_TITLE = "title";
    public static final String C_ASSET_NUMBER = "asset_number";
    public static final String C_ASSET_NAME = "asset_name";
    public static final String C_PARENT_ASSET_NUMBER = "parent_asset_number";
    public static final String C_PARENT_ASSET_NAME = "parent_asset_name";
    public static final String C_VALUE = "value";
    public static final String C_PREV_VALUE = "prev_value";
    public static final String C_DATE_ENTERED = "date_entered";
    public static final String C_NOTES = "notes";
    public static final String C_ENTERED_BY = "entered_by";
    public static final String C_UOM = "uom";
    public static final String C_INSTRUCTIONS = "instructions";
    public static final String C_CHECKSHEET_ID = "checksheet_id";

    @DatabaseField(generatedId = true, canBeNull = false, columnName = C_ID)
    int id;
    @DatabaseField(columnName = C_TITLE)
    String title;
    @DatabaseField(columnName = C_ASSET_NUMBER)
    String assetNumber;
    @DatabaseField(columnName = C_ASSET_NAME)
    String assetName;
    @DatabaseField(columnName = C_PARENT_ASSET_NUMBER)
    String parentAssetNumber;
    @DatabaseField(columnName = C_PARENT_ASSET_NAME)
    String parentAssetName;
    @DatabaseField(columnName = C_VALUE)
    String value;
    @DatabaseField(columnName = C_PREV_VALUE)
    String prevValue;
    @DatabaseField(columnName = C_DATE_ENTERED)
    String dateEntered;
    @DatabaseField(columnName = C_NOTES)
    String notes;
    @DatabaseField(columnName = C_ENTERED_BY)
    String enteredBy;
    @DatabaseField(columnName = C_UOM)
    String uom;
    @DatabaseField(columnName = C_INSTRUCTIONS)
    String instructions;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = C_CHECKSHEET_ID)
    Checksheet checksheet;

    public Reading() {
    }

    public Reading(String title, String asset_number, String asset_name, String parent_asset_number, String parent_asset_name,
                   String value, String prev_value, String uom, String date, String notes, String employee, String instructions) {
        this.title = title;
        this.assetNumber = asset_number;
        this.assetName = asset_name;
        this.parentAssetNumber = parent_asset_number;
        this.parentAssetName = parent_asset_name;
        this.value = value;
        this.prevValue = prev_value;
        this.uom = uom;
        this.dateEntered = date;
        this.notes = notes;
        this.enteredBy = employee;
        this.instructions = instructions;
    }

    public Checksheet getChecksheet() {
        return checksheet;
    }

    public void setChecksheet(Checksheet checksheet) {
        this.checksheet = checksheet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getParentAssetNumber() {
        return parentAssetNumber;
    }

    public void setParentAssetNumber(String parentAssetNumber) {
        this.parentAssetNumber = parentAssetNumber;
    }

    public String getParentAssetName() {
        return parentAssetName;
    }

    public void setParentAssetName(String parentAssetName) {
        this.parentAssetName = parentAssetName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(String prevValue) {
        this.prevValue = prevValue;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
