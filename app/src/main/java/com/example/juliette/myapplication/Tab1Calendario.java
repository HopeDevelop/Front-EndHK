package com.example.juliette.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;

import android.view.View;
import android.view.ViewGroup;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;



public class Tab1Calendario extends Fragment implements OnMonthChangedListener {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1calendario, container, false);

        MaterialCalendarView calendarView = (com.prolificinteractive.materialcalendarview.MaterialCalendarView) rootView.findViewById(R.id.calendar);
        final Calendar calendar = Calendar.getInstance();
        calendarView.setSelectedDate(calendar.getTime());
        calendarView.setSelectedDate(calendar.getTime());

        ListView listView = (ListView) rootView.findViewById(R.id.calenderlist);

        return rootView;
    }
    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {


        // CalenderAdapter calenderAdapter = new CalenderAdapter(getActivity(), student_list_calender);
        // listView.setAdapter(calenderAdapter);
       // Calendar cal = Calendar.getInstance();
        //cal.setTime(date.getDate());
        //int month = cal.get(Calendar.MONTH);
       // List<Event> event = map.get(month);
        //if (event != null && event.size() > 0)
        //    adapter.addItems(event);

       // widget.invalidateDecorators();

    }
}
