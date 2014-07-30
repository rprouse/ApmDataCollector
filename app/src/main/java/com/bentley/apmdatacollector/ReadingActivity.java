package com.bentley.apmdatacollector;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;


public class ReadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ReadingFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class ReadingFragment extends Fragment {

        private int mSequence = 0;
        private View mRootView;
        private Map<String, String> mReading;

        public ReadingFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            mRootView = inflater.inflate(R.layout.fragment_reading, container, false);

            Intent intent = getActivity().getIntent();
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                String sequence = intent.getStringExtra(Intent.EXTRA_TEXT);
                try {
                    mSequence = Integer.parseInt(sequence);
                } catch ( NumberFormatException e ) {
                    e.printStackTrace();
                    return mRootView;
                }
            }

            mReading = ChecksheetDataGenerator.GetIndicatorReading(mSequence);
            SetTextView(R.id.reading_title, ChecksheetDataGenerator.READING_TITLE);
            SetTextView(R.id.reading_sequence, ChecksheetDataGenerator.READING_SEQUENCE);
            SetTextView(R.id.reading_total_count, ChecksheetDataGenerator.READING_TOTAL_COUNT);
            SetTextView(R.id.reading_asset_number, ChecksheetDataGenerator.READING_ASSET_NUMBER);
            SetTextView(R.id.reading_asset_name, ChecksheetDataGenerator.READING_ASSET_NAME);
            SetTextView(R.id.reading_parent_asset_number, ChecksheetDataGenerator.READING_PARENT_ASSET_NUMBER);
            SetTextView(R.id.reading_parent_asset_name, ChecksheetDataGenerator.READING_PARENT_ASSET_NAME);
            SetTextView(R.id.reading_uom, ChecksheetDataGenerator.READING_UOM);
            SetTextView(R.id.reading_value, ChecksheetDataGenerator.READING_VALUE);
            SetTextView(R.id.reading_notes, ChecksheetDataGenerator.READING_NOTES);
            SetTextView(R.id.reading_instructions, ChecksheetDataGenerator.READING_INSTRUCTIONS);

            return mRootView;
        }

        private void SetTextView(int id, String key) {
            TextView tv = (TextView)mRootView.findViewById(id);
            if (tv == null) return;

            tv.setText(mReading.get(key));
        }
    }
}
