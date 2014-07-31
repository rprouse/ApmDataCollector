package com.bentley.apmdatacollector;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.Map;

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
                        ChecksheetDataGenerator.CHECKSHEET_PERCENT,
                        ChecksheetDataGenerator.CHECKSHEET_CODE,
                        ChecksheetDataGenerator.CHECKSHEET_CODE,
                },
                new int[] {
                        R.id.list_item_checksheets_title,
                        R.id.list_item_checksheets_code,
                        R.id.list_item_checksheets_percent,
                        R.id.list_item_checksheets_image,
                        R.id.list_item_checksheets_icon
                }
        );

        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (view.getId() == R.id.list_item_checksheets_icon) {
                    if(textRepresentation.startsWith("ST")) {
                        ((ImageView)view).setImageResource(R.drawable.icon_standardtask);
                    } else {
                        ((ImageView) view).setImageResource(R.drawable.icon_worktask);
                    }
                    return true;
                } else if (view.getId() == R.id.list_item_checksheets_image) {
                    if(textRepresentation.startsWith("ST")) {
                        ((ImageView)view).setImageResource(R.drawable.standardtask);
                    } else {
                        ((ImageView) view).setImageResource(R.drawable.worktask);
                    }
                    return true;
                }
                return false;
            }
        });

        ListView listView = (ListView) rootView.findViewById(R.id.listview_checksheets);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleAdapter adapter = (SimpleAdapter) parent.getAdapter();
                Map<String, String> map = (Map<String, String>)adapter.getItem(position);

                if (map != null) {
                    String code = map.get(ChecksheetDataGenerator.CHECKSHEET_CODE);
                    Intent intent = new Intent(getActivity(), ChecksheetActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, code);
                    getActivity().startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
