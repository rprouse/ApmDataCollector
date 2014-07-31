package com.bentley.apmdatacollector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ReadingActivity extends FragmentActivity implements IReadingProvider {

    private ReadingPagerAdapter mPageAdapter;
    private ViewPager mViewPager;
    List<Map<String, String>> mChecksheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        mChecksheet = ChecksheetDataGenerator.GetChecksheet();

        mPageAdapter = new ReadingPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.reading_pager);
        mViewPager.setAdapter(mPageAdapter);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String strSequence = intent.getStringExtra(Intent.EXTRA_TEXT);
            try {
                int sequence = Integer.parseInt(strSequence);
            } catch ( NumberFormatException e ) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, String> GetIndicatorReading(int sequence){
        if (sequence < 1 || sequence > mChecksheet.size()) return null;
        return mChecksheet.get(sequence-1);
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

    public class ReadingPagerAdapter extends FragmentStatePagerAdapter {

        public ReadingPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ReadingFragment();
            Bundle args = new Bundle();
            args.putInt(ReadingFragment.ARG_SEQUENCE, position+1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return mChecksheet.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Map<String, String> reading = GetIndicatorReading(position+1);
            if (reading != null){
                return reading.get(ChecksheetDataGenerator.READING_TITLE);
            }
            return super.getPageTitle(position);
        }
    }

    public static class ReadingFragment extends Fragment {

        public static final String ARG_SEQUENCE = "sequence";

        private int mSequence = 0;
        private View mRootView;
        private Map<String, String> mReading;
        private IReadingProvider mReadingProvider;

        public ReadingFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            mRootView = inflater.inflate(R.layout.fragment_reading, container, false);

            mReadingProvider = (IReadingProvider)getActivity();

            Bundle args = getArguments();
            mSequence = args.getInt(ARG_SEQUENCE, 1);

            mReading = mReadingProvider.GetIndicatorReading(mSequence);
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
            SetTextView(R.id.reading_prev_value, ChecksheetDataGenerator.READING_PREV_VALUE);
            SetTextView(R.id.reading_date_entered, ChecksheetDataGenerator.READING_DATE_ENTERED);

            return mRootView;
        }

        private void SetTextView(int id, String key) {
            TextView tv = (TextView)mRootView.findViewById(id);
            if (tv == null || mReading == null) return;

            tv.setText(mReading.get(key));
        }
    }
}
