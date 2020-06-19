package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText bill;
    private CheckBox fifteen;
    private CheckBox eighteen;
    private CheckBox twenty;
    private TextView tip;
    private Button calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = findViewById(R.id.billAmount);

        fifteen = findViewById(R.id.normal);
        eighteen = findViewById(R.id.good);
        twenty = findViewById(R.id.great);

        tip = findViewById(R.id.tipAmount);

        calc = findViewById(R.id.calculate);

        fifteen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fifteen.setChecked(true);
                eighteen.setChecked(false);
                twenty.setChecked(false);
                return;
            }
        });

        eighteen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fifteen.setChecked(false);
                eighteen.setChecked(true);
                twenty.setChecked(false);
                return;
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fifteen.setChecked(false);
                eighteen.setChecked(false);
                twenty.setChecked(true);
                return;
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double amount = Double.parseDouble(bill.getText().toString());
                int fifteen_calc = (int) (amount * .15);
                int eighteen_calc = (int) (amount * .18);
                int twenty_calc = (int) (amount * .2);
                int result = 0;

                if (bill.getText().toString().equals("") || (fifteen.isChecked() == false && eighteen.isChecked() == false && twenty.isChecked() == false)) {
                    tip.setText("N/A");
                    return;
                }

                if (fifteen.isChecked()) {
                    if (amount * .15 - fifteen_calc != 0) {
                        result = fifteen_calc + 1;
                    }
                    else result = fifteen_calc;
                    tip.setText("$" + String.valueOf(result));
                    return;
                }

                if (eighteen.isChecked()) {
                    if (amount * .18 - eighteen_calc != 0) {
                        result = eighteen_calc + 1;
                    }
                    else result = eighteen_calc;
                    tip.setText("$" + String.valueOf(result));
                    return;
                }

                if (twenty.isChecked()) {
                    if (amount * .2 - twenty_calc != 0) {
                        result = twenty_calc + 1;
                    }
                    else result = twenty_calc;
                    tip.setText("$" + String.valueOf(result));
                    return;
                }
            }
        });
    }
}