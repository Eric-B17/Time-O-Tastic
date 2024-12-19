package com.example.time_o_tastic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Clock extends Activity {

    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.clock);

        btn = (Button)findViewById(R.id.btnm);
        btn = (Button)findViewById(R.id.btnc);
        btn = (Button)findViewById(R.id.btnt);
        btn = (Button)findViewById(R.id.btns);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clock.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clock.this,Clock.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clock.this,TimeCalculator.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clock.this,SetDate.class);
                startActivity(intent);
            }
        });

        private lateinit var binding: ActivityMainBinding

        override fun onCreate()
    }
}
