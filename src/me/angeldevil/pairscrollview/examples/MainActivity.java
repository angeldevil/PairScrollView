
package me.angeldevil.pairscrollview.examples;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import me.angeldevil.pairscrollview.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        String[] data = {"WebView and ListView", "TextView and ListView", "Inner ListView"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                if (position == 0) {
                    intent.setComponent(new ComponentName(MainActivity.this, WebAndListActivity.class));
                } else if (position == 1) {
                    intent.setComponent(new ComponentName(MainActivity.this, TextViewAndListActivity.class));
                } else {
                    intent.setComponent(new ComponentName(MainActivity.this, InnerListActivity.class));
                }
                startActivity(intent);
            }
        });
    }

}
