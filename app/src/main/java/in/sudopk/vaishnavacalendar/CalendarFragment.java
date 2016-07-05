package in.sudopk.vaishnavacalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.sudopk.coreandroid.Layout;

public class CalendarFragment extends Fragment {
    private RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar, container, false);
        final RecyclerView recyclerView = Layout.findViewById(view, R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CalendarAdapter();
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        VaishnavaCalendar.parseHtml(TestHtml.HTMl);
    }
}
