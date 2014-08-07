
package me.angeldevil.pairscrollview.examples;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import me.angeldevil.pairscrollview.PairScrollView;
import me.angeldevil.pairscrollview.R;

import java.util.ArrayList;

public class WebAndListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_and_list);

        final WebView webView = (WebView) findViewById(R.id.web);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl("http://www.angeldevil.me");
        // webView.loadData("Test</br>Test</br>Test</br>Test</br>Test</br>Test", "text/html", "utf-8");

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
