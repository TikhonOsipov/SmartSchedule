package com.tixon.smartschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentScheduleDay extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    public static FragmentScheduleDay newInstance(int dayOfWeek) {
        FragmentScheduleDay fragment = new FragmentScheduleDay();
        Bundle args = new Bundle();
        args.putInt(Constants.KEY_DAY_OF_WEEK, dayOfWeek);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_schedule_day, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewFragmentScheduleDay);
        layoutManager = new LinearLayoutManager(getActivity());

        int dayOfWeek = getArguments().getInt(Constants.KEY_DAY_OF_WEEK);

        recyclerView.setLayoutManager(layoutManager);
        return v;
    }
}
