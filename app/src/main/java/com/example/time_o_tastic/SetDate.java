package com.example.time_o_tastic;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.Nullable;

public class SetDate extends Activity {

    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.setdates);

        btn = (Button)findViewById(R.id.btnm);
        btn = (Button)findViewById(R.id.btnc);
        btn = (Button)findViewById(R.id.btnt);
        btn = (Button)findViewById(R.id.btns);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDate.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDate.this,Clock.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDate.this,TimeCalculator.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDate.this,SetDate.class);
                startActivity(intent);
            }
        });

        text = findViewById(R.id.showText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });

    public void openDialog(){

            TimePickerDialog dialog = new TimePickerDialog(this, R.style.DialogTheme, TimePickerDialog.OnTimeSetListener(){
            public void onTimeSet(TimePicker timePicker, int hours, int minutes){

            text.setText(String.valueOf(hours)+":"+String.valueOf(minutes));
            }
        }
        15, 00, true);
}
