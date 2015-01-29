package com.example.thenewbostonavs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by AvanSchuijlenborgh on 27-1-2015.
 */
public class SQLiteExample extends Activity implements View.OnClickListener {

    EditText sqlName, sqlHotness, sqlRow;
    Button sqlUpdate, sqlView, sqlGetInfo, sqlModify, sqlDelete;
    Boolean didItWork = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialise();
    }

    private void initialise() {
        setContentView(R.layout.sqliteexample);

        sqlName = (EditText) findViewById(R.id.etSQLNAme);
        sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
        sqlRow = (EditText) findViewById(R.id.etSQLRowId);

        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlView = (Button) findViewById(R.id.bSQLVOpenView);
        sqlDelete = (Button) findViewById(R.id.bSQLDelete);
        sqlGetInfo = (Button) findViewById(R.id.bSQLVGetInfo);
        sqlModify = (Button) findViewById(R.id.bSQLEdit);

        sqlUpdate.setOnClickListener(this);
        sqlView.setOnClickListener(this);
        sqlDelete.setOnClickListener(this);
        sqlModify.setOnClickListener(this);
        sqlGetInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSQLUpdate:


                try {
                    String name = sqlName.getText().toString();
                    String hotness = sqlHotness.getText().toString();

                    HotOrNot entry = new HotOrNot(SQLiteExample.this);

                    entry.open();
                    entry.createEntry(name, hotness);
                    entry.close();
                } catch(Exception e){
                    didItWork = false;

                    String error = e.toString();
                    Dialog d =  new Dialog(this);
                    d.setTitle("Heck Yea!");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if (didItWork){
                        Dialog d =  new Dialog(this);
                        d.setTitle("Heck Yea!");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }


                break;

            case R.id.bSQLVOpenView:

                Intent i = new Intent("com.example.thenewbostonavs.SQLView");
                startActivity(i);
                break;

            case R.id.bSQLVGetInfo:

                String s = sqlRow.getText().toString();
                long l  = Long.parseLong(s);
                HotOrNot hon = new HotOrNot(this);
                try {
                    hon.open();
                    String returnedName = hon.getName(l);
                    String returnedHotness = hon.getHotness(l);
                    hon.close();

                    sqlName.setText(returnedName);
                    sqlHotness.setText(returnedHotness);

                } catch(Exception e){
                    didItWork = false;

                    String error = e.toString();
                    Dialog d =  new Dialog(this);
                    d.setTitle("No Record Found");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }

                break;

            case R.id.bSQLEdit:
                String mName = sqlName.getText().toString();
                String mHotness = sqlHotness.getText().toString();

                String sRow = sqlRow.getText().toString();
                long lRow  = Long.parseLong(sRow);

                HotOrNot honEdit  = new HotOrNot(this);

                try {
                    honEdit.open();

                    honEdit.updateEntry(mName, mHotness,lRow);
                    honEdit.close();

                } catch(Exception e){
                    didItWork = false;

                    String error = e.toString();
                    Dialog d =  new Dialog(this);
                    d.setTitle("Record couldn't be updated!");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if (didItWork){
                        Dialog d =  new Dialog(this);
                        d.setTitle("Record Updated!");
                        TextView tv = new TextView(this);
                        tv.setText("Successfully");
                        d.setContentView(tv);
                        d.show();
                    }
                }

                break;

            case R.id.bSQLDelete:
                String sdRow = sqlRow.getText().toString();
                long dRow  = Long.parseLong(sdRow);

                HotOrNot honDel = new HotOrNot(this);

                try {
                    honDel.open();
                    honDel.deleteEntry(dRow);
                    honDel.close();

                } catch(Exception e){
                    didItWork = false;

                    String error = e.toString();
                    Dialog d =  new Dialog(this);
                    d.setTitle("Record couldn't be deleted!");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if (didItWork){
                        Dialog d =  new Dialog(this);
                        d.setTitle("Record Deleted!");
                        TextView tv = new TextView(this);
                        tv.setText("Successfully");
                        d.setContentView(tv);
                        d.show();
                    }
                }


                break;
        }
    }
}
