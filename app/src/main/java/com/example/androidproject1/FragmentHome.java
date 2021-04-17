package com.example.androidproject1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FragmentHome<MaterialCalendarView> extends Fragment {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home);
//    }

    // View Value
    private CalendarView calendar;
    private TextView dateValue;

    private CalendarView.OnDateChangeListener changeCalendar = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            String date = year + "/" + (month+1) + "/" + dayOfMonth;
            dateValue.setText(date);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        init(rootView);
        calendar.setOnDateChangeListener(changeCalendar);
        calendar.setMinDate(Calendar.getInstance().getTimeInMillis());

        return rootView;
    }

    public void init(ViewGroup rootView) {
        calendar = (CalendarView)rootView.findViewById(R.id.calendarView);
        dateValue = (TextView)rootView.findViewById(R.id.selectedDate);
    }
}
