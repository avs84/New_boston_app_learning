package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AvanSchuijlenborgh on 27-1-2015.
 */
public class SQLiteExample extends Activity implements View.OnClickListener {

    EditText sqlName, sqlHotness;
    Button sqlUpdate, sqlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialise();
    }

    private void initialise() {
        setContentView(R.layout.sqliteexample);

        sqlName = (EditText) findViewById(R.id.etSQLNAme);
        sqlHotness = (EditText) findViewById(R.id.etSQLHotness);

        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlView = (Button) findViewById(R.id.bSQLVOpenView);

        sqlUpdate.setOnClickListener(this);
        sqlView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSQLUpdate:

                String name = sqlName.getText().toString();
                String hotness = sqlHotness.getText().toString();

                HotOrNot entry = new HotOrNot(SQLiteExample.this);
                entry.open();

                entry.createEntry(name, hotness);

                entry.close();

                break;
            case R.id.bSQLVOpenView:

                break;
        }
    }
}
