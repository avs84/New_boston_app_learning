package com.example.thenewbostonavs;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class ExternalData extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView canWrite, canRead,saveAs;
    String state;
    Boolean canW, canR;
    Spinner spinner;
    String[] paths = {"Music", "Pictures", "Download"};
    File path = null;
    File file = null;
    Button confirm, save;
    EditText saveFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialise();
        checkState();
        spinner();
    }

    private void initialise() {
        setContentView(R.layout.externaldata);

        canWrite = (TextView) findViewById(R.id.tvCanWrite);
        canRead = (TextView) findViewById(R.id.tvCanRead);
        spinner = (Spinner) findViewById(R.id.spinner);
        saveAs = (TextView) findViewById(R.id.tvSaveAs);
        confirm = (Button) findViewById(R.id.bConfirmSave);
        save = (Button) findViewById(R.id.bSaveFile);
        saveFile = (EditText) findViewById(R.id.etSaveAs);

        confirm.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    public void checkState() {

        state = Environment.getExternalStorageState();

        //Check state of external state
        if (state.equals(Environment.MEDIA_MOUNTED)){
            //Read and Write
            canWrite.setText("True");
            canRead.setText("True");
            canW = canR = true;
        }else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Read only
            canWrite.setText("false");
            canRead.setText("True");
            canW = false;
            canR = true;
        }else {
            // no Read or write access
            canWrite.setText("false");
            canRead.setText("false");
            canW = canR = false;
        }

    }

    private void spinner() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bConfirmSave:

                save.setVisibility(View.VISIBLE);

                break;

            case R.id.bSaveFile:

                String f = saveFile.getText().toString();
                file = new File(path, f + ".png");

                checkState();
                if (canW == canR == true){

                    path.mkdirs();

                    try {
                        InputStream is = getResources().openRawResource(R.drawable.greenball);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();

                        Toast t = Toast.makeText(ExternalData.this, "File has been Saved", Toast.LENGTH_LONG);
                        t.show();


                        //Update files for the user to use
                        MediaScannerConnection.scanFile(ExternalData.this,
                                                        new String[] {file.toString()},
                                                        null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        Toast t = Toast.makeText(ExternalData.this, "scan complete", Toast.LENGTH_LONG);
                                        t.show();
                                    }
                                });


                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;


        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        position = spinner.getSelectedItemPosition();

        switch (position) {
            case 0:
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

                break;

            case 1:
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;

            case 2:
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
