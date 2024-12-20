package com.example.time_o_tastic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeCalculator extends Activity {

    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        super.onCreate(saveInstanceState);
        setContentView(R.layout.timecalculator);

        btn = (Button) findViewById(R.id.btnm);
        btn = (Button) findViewById(R.id.btnc);
        btn = (Button) findViewById(R.id.btnt);
        btn = (Button) findViewById(R.id.btns);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeCalculator.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeCalculator.this, Clock.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeCalculator.this, TimeCalculator.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeCalculator.this, SetDate.class);
                startActivity(intent);
            }
        });

        TextView currentTime, calculatedTime;

        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            currentTime = findViewById(R.id.current_time);
            calculatedTime = findViewById(R.id.calculated_time);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
            String currentTimee = simpleDateFormat.format(calendar.getTime());
            currentTime.setText(currentTimee);
            try{
                Date date = simpleDateFormat.parse(currentTimee);
                calendar.setTime(date);
                calendar.add(Calendar.MINUTE, 15);
                String result = simpleDateFormat.format(calendar.getTime());
                calculatedTime.setText(result);
            } catch (Exception e) {
                currentTimee.setText(R.string.app_name);
            }
        }
    }
}
