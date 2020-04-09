package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Detail_Absvideo extends AppCompatActivity {
     String abstitle;
   String state;
     WebView absWebView;
     WebSettings absWebSettings;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__absvideo);
        Bundle extra = getIntent().getExtras();
        assert extra != null;
        abstitle = extra.getString("titlename");
        // 그냥 따로하자 ..
        // state=extra.getString("state");//비디오 클릭했는지 인포메이션 클릭했는지 알수있게끔.
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        absWebView = (WebView) findViewById(R.id.abs_webview);

        absWebView.setWebViewClient(new WebViewClient());
        absWebSettings = absWebView.getSettings();
        absWebSettings.setJavaScriptEnabled(true);
        absWebSettings.setSupportMultipleWindows(false);
        absWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        absWebSettings.setLoadWithOverviewMode(true);
        absWebSettings.setUseWideViewPort(true);
        absWebSettings.setSupportZoom(false);
        absWebSettings.setBuiltInZoomControls(false);
        absWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        absWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        absWebSettings.setDomStorageEnabled(true);

        absWebView.loadUrl("https://www.youtube.com/results?search_query=" + abstitle);
        TextView textView = findViewById(R.id.absvideo_text);
        textView.setText(abstitle + " 영상을 보며 따라해 보아요");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }

    //TODO 기능을 넣을지말지 고민. 구상꼬여서 일단이대로
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button_tovideo:
                state = "information";
                return true;
            case R.id.button_tovideo2:
                state = "information";
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}

