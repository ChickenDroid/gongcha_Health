package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class after_traning_Batsal extends AppCompatActivity {
    int nowstate=0;
    private TimerTask task;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_traning__batsal);
        ImageView img=findViewById(R.id.batsal_mainIMG);
        Glide.with(getBaseContext()).load("https://img.mimint.co.kr/beauty/bbs/2019/4/5/20190405145948_xrjpwyzb.gif").into(img);

    }

}
