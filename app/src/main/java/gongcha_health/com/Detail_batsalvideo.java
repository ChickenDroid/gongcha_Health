package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Detail_batsalvideo extends AppCompatActivity {
    private String title;
    private String state;
    private WebView mWebView;
    private WebSettings mWebSettings;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_batsal);
        Bundle extra = getIntent().getExtras();
        assert extra != null;
        title=extra.getString("titlename");
      // 그냥 따로하자 ..
        // state=extra.getString("state");//비디오 클릭했는지 인포메이션 클릭했는지 알수있게끔.
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        mWebView = (WebView) findViewById(R.id.batsal_webview);

        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportMultipleWindows(false);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setSupportZoom(false);
        mWebSettings.setBuiltInZoomControls(false);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebSettings.setDomStorageEnabled(true);

        mWebView.loadUrl("https://www.youtube.com/results?search_query="+title);
        TextView textView=findViewById(R.id.batsalvideo_text);
        textView.setText(title+" 영상을 보며 따라해 보아요");

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
                    state="information";
                    return true;
                case R.id.button_tovideo2:
                    state="information";
                    return true;
                default:
                    return super.onOptionsItemSelected(item);


        }
    }


}
