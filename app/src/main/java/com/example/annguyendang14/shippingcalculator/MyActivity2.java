package com.example.annguyendang14.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity2 extends AppCompatActivity {

    private ShipItem shipItem;

    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        shipItem = new ShipItem();
        weightET = (EditText) findViewById(R.id.editText1);
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        weightET.addTextChangedListener(weightTextWatcher);
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

    private void displayShipping(){
        baseCostTV.setText("$" + String.format("%.02f",shipItem.getmBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",shipItem.getmAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",shipItem.getmTotalCost()));
    }


}
