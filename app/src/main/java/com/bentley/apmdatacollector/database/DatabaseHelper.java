package com.bentley.apmdatacollector.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bentley.apmdatacollector.model.Checksheet;
import com.bentley.apmdatacollector.model.Reading;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "apmdatacollector";
    private static final int DATABASE_VERSION = 1;
    private Dao<Checksheet, Integer> checksheetDao = null;
    private Dao<Reading, Integer> readingDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Checksheet.class);
            TableUtils.createTable(connectionSource, Reading.class);
            createTestData();
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, Checksheet.class, true);
            TableUtils.dropTable(connectionSource, Reading.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (java.sql.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
        }
    }

    /**
     * Use this function to access Checksheet data
     * from database
     *
     * @return
     */
    public Dao<Checksheet, Integer> getChecksheetDao() {
        if (null == checksheetDao) {
            try {
                checksheetDao = getDao(Checksheet.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return checksheetDao;
    }

    /**
     * Use this function to access Reading data
     * from database
     *
     * @return
     */
    public Dao<Reading, Integer> getReadingDao() {
        if (null == readingDao) {
            try {
                readingDao = getDao(Reading.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return readingDao;
    }

    private void createTestData() {
        CreateChecksheet("Inspection route #5", "ST:000050");
        CreateChecksheet("Inspection route #6", "ST:000060");
        CreateChecksheet("Pump Inspections", "WO:000177-WOT:1");
        CreateChecksheet("Oil level checks - trucks", "WO:000231-WOT:1");
        CreateChecksheet("Oil level checks - tractors", "WO:000231-WOT:2");
        CreateChecksheet("Electrical systems", "ST:000312");
        CreateChecksheet("Radiation checks", "WO:000298-WOT:1");
        CreateChecksheet("Back plant route", "ST:000334");
        CreateChecksheet("Yearly inspection", "WO:000143-WOT:1");
        CreateChecksheet("Drive temperature", "WO:000435-WOT:1");
    }

    private void CreateChecksheet(String title, String code) {
        Checksheet checksheet = new Checksheet(title, code, 0);
        DatabaseManager.getInstance().addChecksheet(checksheet);
        checksheet.getReadings().add(new Reading("Clearance - Outboard Bearing", "87-1", "Pump Shaft", "87", "Main Pump", "12.3", "12.2", "mm", "12/12/14", "Hella Echo Park church-key craft beer, irony twee Carles cornhole organic sriracha Bushwick literally readymade. PBR&B chambray pour-over, single-origin coffee selvage whatever biodiesel stumptown twee bespoke.", "Joe Worker", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Temperature of Bearing Cooling Oil", "87-1", "Pump Shaft", "87", "Main Pump", "", "82.2", "C", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Shaft RPM", "87-1", "Pump Shaft", "87", "Main Pump", "", "35", "rpm", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Pump Voltage", "87-2", "Pump Electrical Panel", "87", "Main Pump", "", "11.1", "V", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Pump Amperage", "87-2", "Pump Electrical Panel", "87", "Main Pump", "", "3.2", "a", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Clearance - Outboard Bearing", "88-1", "Pump Shaft", "88", "Secondary Pump", "", "10.1", "mm", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Temperature of Bearing Cooling Oil", "88-1", "Pump Shaft", "88", "Secondary Pump", "", "84.7", "C", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Shaft RPM", "88-1", "Pump Shaft", "88", "Secondary Pump", "", "36", "rpm", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Pump Voltage", "88-2", "Pump Electrical Panel", "88", "Secondary Pump", "", "11.1", "V", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
        checksheet.getReadings().add(new Reading("Pump Amperage", "88-2", "Pump Electrical Panel", "88", "Secondary Pump", "", "3.3", "a", "", "", "", "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo."));
    }

    private Reading CreateReading(Checksheet checksheet, String title, String asset_number, String asset_name, String parent_asset_number, String parent_asset_name,
                               String value, String prev_value, String uom, String date, String notes, String employee) {
        Reading reading = new Reading(title, asset_number, asset_name, parent_asset_number, parent_asset_name, value, prev_value, uom, date, notes, employee,
                "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo.");
        reading.setChecksheet(checksheet);
        return reading;
    }
}
