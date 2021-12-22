package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class TipCalculatorActivity extends AppCompatActivity {

    EditText checkAmountValue;
    EditText partySizeValue;
    Button buttonCompute;
    EditText fifteenPercentTipValue;
    EditText twentyPercentTipValue;
    EditText twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue;
    EditText twentyPercentTotalValue;
    EditText twentyfivePercentTotalValue;

    double Amount;
    int Size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCompute = findViewById(R.id.buttonCompute);
        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (checkAmountValue.getText().toString().length() <= 0)
                    Toast.makeText(getApplicationContext(), "Wrong amount", Toast.LENGTH_SHORT).show();

                else if (partySizeValue.getText().toString().length() == 0 || Integer.parseInt(partySizeValue.getText().toString()) <= 0)
                    Toast.makeText(getApplicationContext(), "Incorrect party size", Toast.LENGTH_SHORT).show();

                else {
                    fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
                    twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
                    twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);

                    fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
                    twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
                    twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

                    Amount = Double.valueOf(checkAmountValue.getText().toString());
                    Size = Integer.valueOf(partySizeValue.getText().toString());

                    fifteenPercentTipValue.setText(String.valueOf(tip(Amount, Size, 0.15)));
                    twentyPercentTipValue.setText(String.valueOf(tip(Amount, Size, 0.20)));
                    twentyfivePercentTipValue.setText(String.valueOf(tip(Amount, Size, 0.25)));

                    fifteenPercentTotalValue.setText(String.valueOf(total(Amount, Size, 0.15)));
                    twentyPercentTotalValue.setText(String.valueOf(total(Amount, Size, 0.20)));
                    twentyfivePercentTotalValue.setText(String.valueOf(total(Amount, Size, 0.25)));
                }
            }
        });
    }

    public int tip(double Amount, int Size, double percentage) {
        int total = (int) Math.ceil((Amount / Size) * percentage);
        return total;
    }

    public int total(double Amount, int Size, double percentage) {
        int total = (int) Math.ceil((Amount / Size) + ((Amount / Size) * percentage));
        return total;
    }

}