
package me.angeldevil.pairscrollview.examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import me.angeldevil.pairscrollview.R;

import java.util.ArrayList;

public class TextViewAndListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_and_list);

        final TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText("Test\nTest\nTest\nTest\nTest\nTest\nTest");

        final ListView list = (ListView) findViewById(R.id.list);
        int count = 40;
        ArrayList<String> data = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            data.add("Text " + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, data);
        TextView header = new TextView(this);
        header.setText("Header");
        list.addHeaderView(header);
        list.setAdapter(adapter);
    }

}
