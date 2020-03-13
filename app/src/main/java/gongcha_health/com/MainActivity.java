package gongcha_health.com;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static int resume;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private training_frag frag1;
    private running_frag frag2;
    private setting_frag frag3;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null &&resume==0){
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
        }


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.training:
                        setFrag(0);
                        break;
                    case R.id.running:
                        setFrag(1);
                        break;
                    case R.id.setting:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        frag1 = new training_frag();
        frag2 = new running_frag();
        frag3 = new setting_frag();
        setFrag(0); // first frag


        /*  커스텀 다이얼로그 part  2020-03-10 */
        if(resume==0) {  //재호출방지


            final Dialog dlg = new Dialog(this);
            dlg.setContentView(R.layout.diet_dialog);
            TextView textView = dlg.findViewById(R.id.text);
            textView.setText("살빼러 가볼까연?");
            ImageView imageView = dlg.findViewById(R.id.image);
            ImageView imageView2 = dlg.findViewById(R.id.image2);
            Glide.with(getBaseContext()).load("https://img.gqkorea.co.kr/gq/2018/06/style_5b275be5a4eb1.gif").override(600, 700).into(imageView);
            Glide.with(getBaseContext()).load("https://t1.daumcdn.net/thumb/R1024x0/?fname=http://bhu.co.kr/data/editor/1808/90c7098bcb641aeaa52825d237744ade_1535539184_93.gif").override(800, 900).into(imageView2);
            WindowManager.LayoutParams params = null;
            params = Objects.requireNonNull(dlg.getWindow()).getAttributes();

            // params.width = (WindowManager.LayoutParams.MATCH_PARENT);

            // params.height = (WindowManager.LayoutParams.MATCH_PARENT);
            dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
            dlg.setCancelable(true);
            dlg.show();
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            Window window = dlg.getWindow();
            int x = (int) (size.x * 0.9f);
            int y = (int) (size.y * 0.9f);
            window.setLayout(x, y);
            Button button = dlg.findViewById(R.id.dialog_OK);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dlg.dismiss();
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setFrag(0);
                    dlg.dismiss();
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setFrag(1); //지금 달리기 이미지커서 느림
                    dlg.dismiss();
                }
            });

            /* 커스텀 다이얼로그 End*/
            ////////////////////////////////
        }

    }
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                frag1=new training_frag();
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                frag2=new running_frag();
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                frag3=new setting_frag();
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v("Resume","resume호출");
        resume++;
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v("stop","stop호출");
        resume++;
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v("Pause","Pause호출");
        resume++;
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v("onRestart","onRestart호출");
    }


}