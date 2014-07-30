package com.bentley.apmdatacollector;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChecksheetFragment extends Fragment {

    private String mCode;

    public ChecksheetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_checksheet, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mCode = intent.getStringExtra(Intent.EXTRA_TEXT);
            getActivity().setTitle(mCode);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                ChecksheetDataGenerator.GetChecksheet(),
                R.layout.list_item_checksheet,
                new String[] {
                        ChecksheetDataGenerator.READING_ASSET_NUMBER,
                        ChecksheetDataGenerator.READING_ASSET_NAME,
                        ChecksheetDataGenerator.READING_PARENT_ASSET_NUMBER,
                        ChecksheetDataGenerator.READING_PARENT_ASSET_NAME,
                        ChecksheetDataGenerator.READING_TITLE,
                        ChecksheetDataGenerator.READING_DATE_ENTERED
                },
                new int[] {
                        R.id.list_item_checksheet_asset_number,
                        R.id.list_item_checksheet_asset_name,
                        R.id.list_item_checksheet_parent_asset_number,
                        R.id.list_item_checksheet_parent_asset_name,
                        R.id.list_item_checksheet_title,
                        R.id.list_item_checksheet_date
                }
        );
        ListView listView = (ListView) rootView.findViewById(R.id.listview_checksheet);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleAdapter adapter = (SimpleAdapter) parent.getAdapter();
                Map<String, String> map = (Map<String, String>)adapter.getItem(position);

                if (map != null) {
                    String sequence = map.get(ChecksheetDataGenerator.READING_SEQUENCE);
                    Intent intent = new Intent(getActivity(), ReadingActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, sequence);
                    getActivity().startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
