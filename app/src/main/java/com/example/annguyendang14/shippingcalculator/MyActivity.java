package com.example.annguyendang14.shippingcalculator;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {

    private ArrayList<ShipItem> shipItems;

    private EditText numpackET;
    private LinearLayout weightLL;
    private LinearLayout costLL;
    private int numpack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        shipItems = new ArrayList<ShipItem>();
        numpackET = (EditText) findViewById(R.id.editText1);
        weightLL = (LinearLayout) findViewById(R.id.weigh);
        costLL = (LinearLayout) findViewById(R.id.cost);
        numpack = 1;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout rel1 = new LinearLayout(this);
        rel1.setOrientation(LinearLayout.HORIZONTAL);
        rel1.setLayoutParams(params);
        TextView weight1 = new TextView(this);
        weight1.setText("1st weight: ");
        weight1.setTextSize(20);

        EditText weight1E = new EditText(this);
        weight1E.setInputType(InputType.TYPE_CLASS_NUMBER);
        weight1E.setMinWidth(500);
        

        rel1.addView(weight1);
        rel1.addView(weight1E);
        weightLL.addView(rel1);





    }



 /*   private TextWatcher weightTextWatcher = new TextWatcher() {
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
    }*/


}

class CustomTextWatcher implements TextWatcher {
    private ShipItem shipItem;

    public CustomTextWatcher(ShipItem item) {
        shipItem = item;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
