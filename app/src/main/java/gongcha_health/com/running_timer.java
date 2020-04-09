package gongcha_health.com;

import android.annotation.SuppressLint;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class running_timer extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_timer);
        Intent intent = getIntent();
        TextView textCon = (TextView)findViewById(R.id.contents);
        TextView textTime = (TextView)findViewById(R.id.time);
        TextView stretchDes = (TextView)findViewById(R.id.stretching_des);
        Button startBtn = (Button)findViewById(R.id.start);
        ImageView stretchVideo = (ImageView)findViewById(R.id.stretching_video);

        int time = intent.getExtras().getInt("time");
        String context = intent.getExtras().getString("context");
        textCon.setText(context);
        textTime.setText(String.valueOf(time) + ":00");
        stretchDes.setText("운동 전후에 스트레칭으로 몸을 풀면\n긴장된 근육을 이완시켜주고 피로를 덜어줍니다.\n스트레칭 동영상 바로가기");

        stretchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=8i67VLbTMsY"));
                startActivity(intent);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TimerDialog dig = new TimerDialog(v.getContext(),"타이머 입니다", 10);
                dig.setOnClickCancelButton(new TimerDialog.ITimerDialogListener() {
                    @Override
                    public void onTimeout() {
                        Toast.makeText(getApplicationContext(), "Timeout", Toast.LENGTH_LONG).show();
                    }
                });
                dig.addButton("Button 01", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Button 01 Click", Toast.LENGTH_LONG).show();
                    }
                });
                dig.addButton("Button 02", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Button 02 Click", Toast.LENGTH_LONG).show();
                    }
                });
                dig.show();
            }
        });
    }
}

