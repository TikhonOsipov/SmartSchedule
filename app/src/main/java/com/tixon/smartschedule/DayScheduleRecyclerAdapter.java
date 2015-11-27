package com.tixon.smartschedule;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class DayScheduleRecyclerAdapter extends
        RecyclerView.Adapter<DayScheduleRecyclerAdapter.DayScheduleViewHolder> {

    private int dayOfWeek;

    public DayScheduleRecyclerAdapter(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public DayScheduleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(DayScheduleViewHolder dayScheduleViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class DayScheduleViewHolder extends RecyclerView.ViewHolder {

        public DayScheduleViewHolder(View itemView) {
            super(itemView);
        }
    }
}
