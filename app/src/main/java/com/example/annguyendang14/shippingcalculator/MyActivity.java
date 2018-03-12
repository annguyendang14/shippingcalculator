package com.example.annguyendang14.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private ShipItem shipItem;


    private EditText weightET;
    private EditText numET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView subtotalTV;
    private TextView totalCostTV;
    private int numPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        shipItem = new ShipItem();
        weightET = (EditText) findViewById(R.id.editText1);
        numET = (EditText) findViewById(R.id.editText0);
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        subtotalTV = (TextView) findViewById(R.id.textView8);
        totalCostTV = (TextView) findViewById(R.id.textView10);

        weightET.addTextChangedListener(weightTextWatcher);
        numET.addTextChangedListener(numTextWatcher);
        numPackage = 1;
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher numTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                numPackage = (int) Double.parseDouble(s.toString());
            } catch (NumberFormatException e){
                numPackage = 1;
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping(){
        baseCostTV.setText("$" + String.format("%.02f",shipItem.getmBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",shipItem.getmAddedCost()));
        subtotalTV.setText("$" + String.format("%.02f",shipItem.getmTotalCost()));
        totalCostTV.setText("$"+String.format("%.02f",shipItem.getmTotalCost()*numPackage));
    }


}
