package com.example.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView totalText;
    private TextView tipText;
    private TextView percentText;
    private SeekBar seekBarTip;
    private EditText edtText;

    private double percentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalText = findViewById(R.id.textTotal);
        tipText = findViewById(R.id.textTip);
        percentText = findViewById(R.id.textPercentage);
        edtText = findViewById(R.id.edtValue);
        seekBarTip = findViewById(R.id.seekBarTip);

        //SeekBar listener
        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                percentage = progress;
                percentText.setText(Math.round(percentage) + " % ");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calculate() {
        String valueRecover = edtText.getText().toString();

        if (valueRecover == null || valueRecover.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter a value first", Toast.LENGTH_LONG).show();
        } else  {
            double valueType = Double.parseDouble(valueRecover);
            double tip = valueType * (percentage / 100);
            double total = tip  + valueType;

            tipText.setText("$ " + tip);
            totalText.setText("$ " + total);

        }
    }
}