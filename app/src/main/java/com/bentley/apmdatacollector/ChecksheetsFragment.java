package com.bentley.apmdatacollector;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChecksheetsFragment extends Fragment {

    public ChecksheetsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_checksheets, container, false);

        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                ChecksheetDataGenerator.GetChecksheets(),
                R.layout.list_item_checksheets,
                new String[] {
                        ChecksheetDataGenerator.CHECKSHEET_TITLE,
                        ChecksheetDataGenerator.CHECKSHEET_CODE,
                        ChecksheetDataGenerator.CHECKSHEET_PERCENT
                },
                new int[] {
                        R.id.list_item_checksheets_title,
                        R.id.list_item_checksheets_code,
                        R.id.list_item_checksheets_percent
                }
        );
        ListView listView = (ListView) rootView.findViewById(R.id.listview_checksheets);
        listView.setAdapter(adapter);
        return rootView;
    }
}
