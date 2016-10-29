package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import in.sudopk.coreandroid.Layout;

public class CalendarPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar_pager, container, false);

        final Toolbar toolbar = Layout.findViewById(view, R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final ViewPager viewPager = Layout.findViewById(view, R.id.viewPager);
        ((TabLayout) Layout.findViewById(view, R.id.tabs)).setupWithViewPager(viewPager);

        final CalendarPagerAdapter pagerAdapter = new CalendarPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.getCount() / 2);
        return view;
    }

    private class CalendarPagerAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_PAGES = 7;

        public CalendarPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            final Calendar calendar = getCalendar(position);
            return CalendarFragment.newInstance(
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        private Calendar getCalendar(int position) {
            final Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, getMonthOffset(position));
            return calendar;
        }

        private int getMonthOffset(final int position) {
            return position - (getCount() / 2);
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            final Calendar calendar = getCalendar(position);
            return (calendar.get(Calendar.MONTH) + 1) + " / " + calendar.get(Calendar.YEAR);
        }
    }
}