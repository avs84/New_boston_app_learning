package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by AvanSchuijlenborgh on 30-11-2014.
 */
public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    TextView question, test;
    //RadioButton Crazy, Sexy, Both;
    Button returnData;
    RadioGroup selectionList;
    //Bundle gotBasket;
    String gotBread, setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        getData();
        question.setText(gotBread);

    }

    private void getData() {
        //gotBasket = getIntent().getExtras();
        //gotBread = gotBasket.getString("key");

    }

    private void initialize() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvTest);
        returnData = (Button) findViewById(R.id.bReturn);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        returnData.setOnClickListener(this);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bReturn:
                Intent person = new Intent();
                Bundle backpack = new Bundle();
                backpack.putString("Answer", setData);
                person.putExtras(backpack);
                setResult(RESULT_OK, person);
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int cID) {

        switch (cID) {
            case R.id.rCrazy:
                setData = "Probably right!";
                break;
            case R.id.rSexy:
                setData = "Definitely right!";
                break;
            case R.id.rBoth:
                setData = "Spot On!";
                break;

        }

        test.setText(setData);
    }
}