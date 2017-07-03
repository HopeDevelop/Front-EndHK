package com.example.juliette.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;



public class Tab1Calendario extends Fragment implements OnMonthChangedListener {


    String Navigation_URL = "http://192.168.100.5:84/api/academics/getEvents";
    String access_token;
    ListView listView;
    com.prolificinteractive.materialcalendarview.MaterialCalendarView calendarView;
    //ArrayList<CalenderPojoStudent> student_list_calender = new ArrayList<>();

    private HashMap<Integer, List<Event>> map = new HashMap<>();
    private List<CalendarDay> calevents = new ArrayList<>();

    private Calendar cal;
    private List<Event> eventList = new ArrayList<>();


    private CalendarAdapter adapter;
    private List<CalendarDay> events = new ArrayList<>();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1calendario, container, false);
        getActivity().setTitle("");
        setHasOptionsMenu(true);

        calendarView = (com.prolificinteractive.materialcalendarview.MaterialCalendarView) view.findViewById(R.id.calendar);
        final Calendar calendar = Calendar.getInstance();
        calendarView.setSelectedDate(calendar.getTime());
        calendarView.setSelectedDate(calendar.getTime());


        listView = (ListView) view.findViewById(R.id.calenderlist);
        adapter = new CalendarAdapter(getActivity(),eventList);
        // listView.setAdapter(adapter);

        //  calendarView.addDecorator(new HighlightWeekendsDecorator());
        //calendarView.addDecorator(new OneDayDecorator());
        // calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays));
        // calendarView.addView(onMonthChanged(calendarView,date));
        // calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays));
        //calendarView.addDecorator(new MySelectorDecorator(getActivity()));


        // calendarView.addDecorator(new EventDecorator("#FF0000",student_list_calender));
        //  calendarView.addDecorator(new EventDecorator("",));
        //calendarView.setDateTextAppearance(View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);


        //SessionManagement session = new SessionManagement(getContext());
        //session.checkLogin();
        //access_token = session.getAccesstToken();
        //makeJsonObjectRequest();


        return view;
    }

    // List<Event> events = new ArrayList<>();

    private void makeJsonObjectRequest() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

        // i copied your json to load form assets folder
        // in our case you can get the json from the server
        // or any other location of your choice
        String response = loadJSONFromAsset("event.json");
        try {
            JSONArray jArray = new JSONArray(response);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String StartDate = jsonObject.getString("StartDate");
                Date date = simpleDateFormat.parse(StartDate);

                Log.d("Date ",""+date);
                CalendarDay day = CalendarDay.from(date);
                events.add(day);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventDecorator eventDecorator = new EventDecorator(Color.RED, events);
        calendarView.addDecorator(eventDecorator);

    }
    public String loadJSONFromAsset(String path) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(path);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
   /* private void makeJsonObjectRequest() {

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = Navigation_URL;


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            JSONArray jArray = new JSONArray(response);
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject jsonObject = jArray.getJSONObject(i);
                                String StartDate = jsonObject.getString("StartDate");
                                String Title = jsonObject.getString("Title");


                                try {
                                    Date date = simpleDateFormat.parse(StartDate);

                                    Log.d("Date ", "" + date);
                                    CalendarDay day1 = CalendarDay.from(date);
                                    Event event = new Event(date, Title);
                                    cal = Calendar.getInstance();
                                    cal.setTime(date);
                                    int month = cal.get(Calendar.MONTH);
                                    if (!map.containsKey(month)) {
                                        List<Event> events = new ArrayList<>();
                                        events.add(event);
                                        map.put(month, events);
                                    } else {
                                        List<Event> events = map.get(month);
                                        events.add(event);
                                        map.put(month, events);

                                    }
                                    calevents.add(day1);

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }


                            }

                            //CalenderAdapter calenderAdapter = new CalenderAdapter(getActivity(), student_list_calender);
                            //listView.setAdapter(calenderAdapter);
                            cal = Calendar.getInstance();
                            int month = cal.get(Calendar.MONTH);
                            List<Event> event = map.get(month);
                            if (event != null && event.size() > 0)
                                adapter.addItems(event);
                            listView.setAdapter(adapter);
                            EventDecorator eventDecorator = new EventDecorator(Color.RED, calevents);
                            calendarView.addDecorator(eventDecorator);

                        } catch (JSONException e) {
                            makeText(getContext(), "Fetch failed!", LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                        //
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                makeText(getContext(), error.toString(), LENGTH_LONG).show();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer " + access_token);
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
/*
            @Override
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("id", master_id);
                map.put("accessID", accessID);
                map.put("currentUser", master_id);
                return map;

            } */ /*
        };


        requestQueue.add(stringRequest);

    }*/


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_user_area, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                // do s.th.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {


        // CalenderAdapter calenderAdapter = new CalenderAdapter(getActivity(), student_list_calender);
        // listView.setAdapter(calenderAdapter);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date.getDate());
        int month = cal.get(Calendar.MONTH);
        List<Event> event = map.get(month);
        if (event != null && event.size() > 0)
            adapter.addItems(event);

        widget.invalidateDecorators();

    }


}