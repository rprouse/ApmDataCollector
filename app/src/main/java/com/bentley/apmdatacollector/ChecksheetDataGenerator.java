package com.bentley.apmdatacollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ChecksheetDataGenerator {
    public static final String CHECKSHEET_TITLE = "checksheet_title";
    public static final String CHECKSHEET_CODE = "checksheet_code";
    public static final String CHECKSHEET_PERCENT = "checksheet_percent";

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
}
