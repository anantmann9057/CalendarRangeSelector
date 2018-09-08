package com.example.jatun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;

import static com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final java.util.Date today=new java.util.Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);


        final CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(java.util.Date date) {
                // String selectedDate= DateFormat.getDateInstance(DateFormat.FULL).format(date);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                String selectedDate = "" + cal.get(Calendar.DAY_OF_MONTH) + "" + (cal.get(Calendar.MONTH) + 1) + "" + cal.get(Calendar.YEAR);
                Toast.makeText(MainActivity.this, selectedDate, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onDateUnselected(java.util.Date date) {
                Toast.makeText(MainActivity.this, "dates unselected", Toast.LENGTH_SHORT).show();

            }

        });

    }
}
