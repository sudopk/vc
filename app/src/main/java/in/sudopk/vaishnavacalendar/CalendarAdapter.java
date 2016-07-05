package in.sudopk.vaishnavacalendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {
    @Override
    public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new VH(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.calendar_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class VH extends RecyclerView.ViewHolder {
        VH(final View itemView) {
            super(itemView);
        }
    }
}
