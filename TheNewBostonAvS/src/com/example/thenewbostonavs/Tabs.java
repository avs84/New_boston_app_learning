package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TabHost.TabSpec ourSpec;
    TextView showResults;
    long start, stop, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        th = (TabHost) findViewById(R.id.tabHost);
        th.setup();

        Button newTab = (Button) findViewById(R.id.bAddTab);
        Button bStart = (Button) findViewById(R.id.bStartWatch);
        Button bStop = (Button) findViewById(R.id.bStopWatch);
        showResults = (TextView) findViewById(R.id.tvShowResults);

        newTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

        //define tabs
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("Stopwatch");
        th.addTab(specs);
        //end define tab, repeat for every tab.

        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Tab 2");
        th.addTab(specs);
        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Add a tab");
        th.addTab(specs);

        start = 0;
     }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.bAddTab:

                   ourSpec = th.newTabSpec("tag1");
                   ourSpec.setContent(new TabHost.TabContentFactory() {

                       @Override
                       public View createTabContent(String tag) {
                           TextView text = new TextView(Tabs.this);
                           text.setText("You've created a new Tab!");
                           return (text);
                       }
                   });

                   ourSpec.setIndicator("New");
                   th.addTab(ourSpec);

                   break;

               case R.id.bStartWatch:
                    start = System.currentTimeMillis();

                   break;

               case R.id.bStopWatch:
                   stop = System.currentTimeMillis();

                   if (start != 0) {
                       results = stop - start;
                       int millis = (int) results % 100;
                       int second = ((int) results/1000) % 60;
                       int minutes = ((int) results / 1000) / 60;


                       showResults.setText(String.format("%d:%02d,%02d:%02d",minutes,second,millis ));
                   }
                   break;
           }


    }
}
