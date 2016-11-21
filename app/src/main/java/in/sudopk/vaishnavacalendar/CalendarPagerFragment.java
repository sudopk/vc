package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
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

public class CalendarPagerFragment extends Fragment implements CalendarFragment.Container {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar_pager, container, false);

        final Toolbar toolbar = Layout.findViewById(view, R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // TODO Use res string OR Remove once location functionality is available.
        toolbar.setSubtitle("Palo Alto");

        final ViewPager viewPager = Layout.findViewById(view, R.id.viewPager);
        ((TabLayout) Layout.findViewById(view, R.id.tabs)).setupWithViewPager(viewPager);

        final CalendarPagerAdapter pagerAdapter = new CalendarPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.getCount() / 2);
        return view;
    }

    @Override
    public void onChangeLocationRequest() {
        DialogFragment fragment = LocationFragment.newInstance();
        fragment.show(getChildFragmentManager(), null);
    }

    private class CalendarPagerAdapter extends FragmentStatePagerAdapter {

        public CalendarPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            final Calendar calendar = CalendarUtil.getCalendar(getMonthOffset(position));
            return CalendarFragment.newInstance(
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
//            return LocationFragment.newInstance();
        }

        @Override
        public int getCount() {
            return CalendarStore.MONTHS_TO_STORE;
        }

        private int getMonthOffset(final int position) {
            return position - (getCount() / 2);
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            final Calendar calendar = CalendarUtil.getCalendar(getMonthOffset(position));
            return (calendar.get(Calendar.MONTH) + 1) + " / " + calendar.get(Calendar.YEAR);
        }
    }
}