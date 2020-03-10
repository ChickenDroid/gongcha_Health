package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import gongcha_health.com.R;

public class Training_batsal extends AppCompatActivity {
    /*  트레이닝의 첫번째 뷰페이저의 리사이클러뷰 모든아이템의 모델   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_batsal);
        String title="";
        String content="";
        Bundle extra=getIntent().getExtras();
        title=extra.getString("title");
        content=extra.getString("content");
        TextView testtext1=findViewById(R.id.testtext1);
        TextView testtext2=findViewById(R.id.testtext2);
        testtext1.setText(title);
        testtext2.setText(content);
    }
}
