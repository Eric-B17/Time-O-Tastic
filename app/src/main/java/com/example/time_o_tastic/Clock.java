package com.example.time_o_tastic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.zip.Inflater;

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

        private lateinit var Inflater ActivityMainBinding;
        binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            viewModel.hourLeftDisplayManager.digitDisplayLiveData.observe(this) { map ->
                    setupLayoutWithNewDigit(binding.layoutHourLeft, map)
            }

            viewModel.hourRightDisplayManager.digitDisplayLiveData.observe(this) { map ->
                    setupLayoutWithNewDigit(binding.layoutHourRight, map)
            }

            viewModel.secondsLeftDisplayManager.digitDisplayLiveData.observe(this) { map ->
                    setupLayoutWithNewDigit(binding.layoutSecondsLeft, map)
            }

            viewModel.secondsRightDisplayManager.digitDisplayLiveData.observe(this) { map ->
                    setupLayoutWithNewDigit(binding.layoutSecondsRight, map)
            }

            viewModel.startCounting()
        }

        private fun setupLayoutWithNewDigit(binding: LayoutDigitDisplayBinding, map: Map<Int, Int>) {
            styleCardView(binding.segmentTop.root, map[R.id.segmentTop]!!)
            styleCardView(binding.segmentTopLeft.root, map[R.id.segmentTopLeft]!!)
            styleCardView(binding.segmentTopRight.root, map[R.id.segmentTopRight]!!)
            styleCardView(binding.segmentMiddle.root, map[R.id.segmentMiddle]!!)
            styleCardView(binding.segmentBottomLeft.root, map[R.id.segmentBottomLeft]!!)
            styleCardView(binding.segmentBottomRight.root, map[R.id.segmentBottomRight]!!)
            styleCardView(binding.segmentBottom.root, map[R.id.segmentBottom]!!)
        }

        private fun styleCardView(materialCardView: MaterialCardView, @ColorRes colorRes: Int) {
            materialCardView.apply {
                val resolvedColor = ContextCompat.getColor(context, colorRes)
                setCardBackgroundColor(resolvedColor)
            }
        }
    }
    }
}
