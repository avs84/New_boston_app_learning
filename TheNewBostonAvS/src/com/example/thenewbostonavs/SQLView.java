package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by AvanSchuijlenborgh on 27-1-2015.
 */
public class SQLView extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialise();

        HotOrNot info = new HotOrNot(this);
        try {
            info.open();
            String data = info.getData();
            info.close();

        } catch (SQLException e) {


        }

    }

    private void initialise() {
        setContentView(R.layout.sqlview);

        tv = (TextView) findViewById(R.id.tvSQLInfo);


    }
}
