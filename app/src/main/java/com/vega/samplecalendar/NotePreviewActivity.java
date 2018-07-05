package com.vega.samplecalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.applandeo.materialcalendarview.EventDay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NotePreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_preview_activity);
        Intent intent = getIntent();
        TextView note = (TextView) findViewById(R.id.note);
        TextView date = findViewById(R.id.date);
        if (intent != null) {
            Object event = intent.getParcelableExtra(MainActivity.EVENT);
            if(event instanceof MyEventDay){
                MyEventDay myEventDay = (MyEventDay)event;
                note.setText(myEventDay.getNote());
                date.setText(getFormattedDate(myEventDay.getCalendar().getTime()));
                return;
            }
            if(event instanceof EventDay){
                EventDay eventDay = (EventDay)event;
                getSupportActionBar().setTitle(getFormattedDate(eventDay.getCalendar().getTime()));
            }
        }
    }
    public static String getFormattedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return simpleDateFormat.format(date);
    }
}
