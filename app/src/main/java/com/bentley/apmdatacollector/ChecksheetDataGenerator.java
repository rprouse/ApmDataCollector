package com.bentley.apmdatacollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ChecksheetDataGenerator {
    public static final String CHECKSHEET_TITLE = "checksheet_title";
    public static final String CHECKSHEET_CODE = "checksheet_code";
    public static final String CHECKSHEET_PERCENT = "checksheet_percent";

    public static final String READING_TITLE = "reading_title";
    public static final String READING_ASSET_NUMBER = "reading_asset_number";
    public static final String READING_ASSET_NAME = "reading_asset_name";
    public static final String READING_PARENT_ASSET_NUMBER = "reading_parent_asset_number";
    public static final String READING_PARENT_ASSET_NAME = "reading_parent_asset_name";
    public static final String READING_SEQUENCE = "reading_sequence";
    public static final String READING_TOTAL_COUNT = "reading_total_count";
    public static final String READING_VALUE = "reading_value";
    public static final String READING_PREV_VALUE = "reading_prev_value";
    public static final String READING_DATE_ENTERED = "reading_date_entered";
    public static final String READING_NOTES = "reading_notes";
    public static final String READING_ENTERED_BY = "reading_entered_by";
    public static final String READING_UOM = "reading_uom";
    public static final String READING_INSTRUCTIONS = "reading_instructions";

    public static List<Map<String, String>> GetChecksheets() {
        List<Map<String, String>> retVal = new ArrayList<Map<String, String>>();

        retVal.add(CreateChecksheet("Inspection route #5", "ST:000050", "10%"));
        retVal.add(CreateChecksheet("Inspection route #6", "ST:000060", "0%"));
        retVal.add(CreateChecksheet("Pump Inspections", "WO:000177-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Oil level checks - trucks", "WO:000231-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Oil level checks - tractors", "WO:000231-WOT:2", "0%"));
        retVal.add(CreateChecksheet("Electrical systems", "WO:000217-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Radiation checks", "WO:000298-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Back plant route", "WO:000334-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Yearly inspection", "WO:000143-WOT:1", "0%"));
        retVal.add(CreateChecksheet("Drive temperature", "WO:000435-WOT:1", "0%"));

        return retVal;
    }

    private static Map<String, String> CreateChecksheet(String title, String code, String percent) {
        Map<String, String> map = new HashMap<String, String>(3);
        map.put(CHECKSHEET_TITLE, title);
        map.put(CHECKSHEET_CODE, code);
        map.put(CHECKSHEET_PERCENT, percent);
        return map;
    }

    public static List<Map<String, String>> GetChecksheet( String code ) {
        List<Map<String, String>> retVal = new ArrayList<Map<String, String>>();

        retVal.add(CreateReading("Clearance - Outboard Bearing", "87-1", "Pump Shaft", "87", "Main Pump", 1, 10, "12.3", "12.2", "mm", "12/12/14", "Hella Echo Park church-key craft beer, irony twee Carles cornhole organic sriracha Bushwick literally readymade. PBR&B chambray pour-over, single-origin coffee selvage whatever biodiesel stumptown twee bespoke.", "Joe Worker"));
        retVal.add(CreateReading("Temperature of Bearing Cooling Oil", "87-1", "Pump Shaft", "87", "Main Pump", 2, 10, "", "82.2", "C", "", "", ""));
        retVal.add(CreateReading("Shaft RPM", "87-1", "Pump Shaft", "87", "Main Pump", 3, 10, "", "35", "rpm", "", "", ""));
        retVal.add(CreateReading("Pump Voltage", "87-2", "Pump Electrical Panel", "87", "Main Pump", 4, 10, "", "11.1", "V", "", "", ""));
        retVal.add(CreateReading("Pump Amperage", "87-2", "Pump Electrical Panel", "87", "Main Pump", 5, 10, "", "3.2", "a", "", "", ""));
        retVal.add(CreateReading("Clearance - Outboard Bearing", "88-1", "Pump Shaft", "88", "Secondary Pump", 6, 10, "", "10.1", "mm", "", "", ""));
        retVal.add(CreateReading("Temperature of Bearing Cooling Oil", "88-1", "Pump Shaft", "88", "Secondary Pump", 7, 10, "", "84.7", "C", "", "", ""));
        retVal.add(CreateReading("Shaft RPM", "88-1", "Pump Shaft", "88", "Secondary Pump", 8, 10, "", "36", "rpm", "", "", ""));
        retVal.add(CreateReading("Pump Voltage", "88-2", "Pump Electrical Panel", "88", "Secondary Pump", 9, 10, "", "11.1", "V", "", "", ""));
        retVal.add(CreateReading("Pump Amperage", "88-2", "Pump Electrical Panel", "88", "Secondary Pump", 10, 10, "", "3.3", "a", "", "", ""));

        return retVal;
    }

    private static Map<String, String> CreateReading(String title, String asset_number, String asset_name, String parent_asset_number, String parent_asset_name,
                                                     int sequence, int total, String value, String prev_value, String uom, String date, String notes, String employee) {
        if (date.isEmpty()) {
            date = "Pending";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put(READING_TITLE, title);
        map.put(READING_ASSET_NUMBER, asset_number);
        map.put(READING_ASSET_NAME, asset_name);
        map.put(READING_PARENT_ASSET_NUMBER, parent_asset_number);
        map.put(READING_PARENT_ASSET_NAME, parent_asset_name);
        map.put(READING_SEQUENCE, Integer.toString(sequence));
        map.put(READING_TOTAL_COUNT, Integer.toString(total));
        map.put(READING_VALUE, value);
        map.put(READING_PREV_VALUE, prev_value);
        map.put(READING_DATE_ENTERED, date);
        map.put(READING_NOTES, notes);
        map.put(READING_ENTERED_BY, employee);
        map.put(READING_UOM, uom);
        map.put(READING_INSTRUCTIONS, "Dreamcatcher Vice authentic Pinterest banjo literally tofu, XOXO skateboard occupy Etsy lo-fi Neutra kogi photo booth. Pour-over Shoreditch normcore beard Cosby sweater, vegan organic fashion axe pop-up photo booth High Life raw denim banjo.");
        return map;
    }
}
