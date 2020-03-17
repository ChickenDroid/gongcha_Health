package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gongcha_health.com.Adapter.RecyclerAdapter_training1;
import gongcha_health.com.Adapter.batsal_testAdapter;
import gongcha_health.com.Model.Traing_data;

public class Training_batsal extends AppCompatActivity {
    private batsal_testAdapter recyclerAdapter_training1;
    boolean nodata =false;
    /*  트레이닝의 첫번째 뷰페이저의 리사이클러뷰 모든아이템의 모델   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_batsal);
        Random random = new Random();
        int randomValue = random.nextInt(6);
        MainActivity.resume++; //로딩화면 및 다이얼로그 재호출 방지
        String title = "";
        String content = "";
        int daycount;
        Bundle extra = getIntent().getExtras();
        assert extra != null;
        title = extra.getString("title");
        content = extra.getString("content");
        daycount=extra.getInt("daycount");
        assert content != null;
        if (content.equals("휴식"))
            nodata = true;
        TextView testtext1 = findViewById(R.id.testtext1);
        TextView testtext2 = findViewById(R.id.testtext2);
        testtext2.setText(content);
        testtext2.setTextColor(Color.parseColor("#000000"));
        RecyclerView recyclerView = findViewById(R.id.batsal_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter_training1 = new batsal_testAdapter();
        recyclerView.setAdapter(recyclerAdapter_training1);
        ActionBar actionBar=getSupportActionBar();
        if (nodata) {
            assert actionBar != null;
            actionBar.setTitle("휴식 일자");
            testtext1.setText("뱃살 빼기 "+daycount+"일차 오늘은 푹 쉬세요");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ImageView imageView = findViewById(R.id.batsal_image);
            Glide.with(getBaseContext()).load("data:image/jpeg;base64,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").override(500, 300).into(imageView);
            testtext2.setText("당신의 몸과 근육이 휴식을 취해야 합니다.");
            testtext2.setTextSize(30);
            findViewById(R.id.batsal_training_start).setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
            recyclerView.setAdapter(recyclerAdapter_training1);
        } else {
            assert actionBar != null;
            actionBar.setTitle(title);
            testtext1.setText("뱃살 빼기 "+daycount+"일차 마지막 까지 힘내세용");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ImageView imageView = findViewById(R.id.batsal_image);
            /*  여기서 after_training_Batsal로 화면전환할때는 extra값 넘기거나 그냥첨부터 하이니즈로시작으로.  */
            findViewById(R.id.batsal_training_start).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Training_batsal.this,after_traning_Batsal.class);
                    startActivity(intent);
                }
            });
            /*  이미지가 너무지겹기에 랜덤이벤트로 발생  */
            if(randomValue==0)
                Glide.with(getBaseContext()).load("data:image/jpeg;base64,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").override(500, 300).into(imageView);
            else if(randomValue==1)
                Glide.with(getBaseContext()).load("https://dispatch.cdnser.be/wp-content/uploads/2017/09/20170927170549_1.gif").override(500, 300).into(imageView);
            else if(randomValue==2)
                Glide.with(getBaseContext()).load("https://img.mimint.co.kr/beauty/bbs/2019/2/18/20190218170630_ljfltpay.gif").override(500, 300).into(imageView);
            else if(randomValue==3)
                Glide.with(getBaseContext()).load("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F162AE1334F59F86A07").override(500, 300).into(imageView);
            else if(randomValue==4)
                Glide.with(getBaseContext()).load("https://img.mimint.co.kr/beauty/bbs/2019/4/5/20190405145948_xrjpwyzb.gif").override(500, 300).into(imageView);
            else
                Glide.with(getBaseContext()).load("https://i.pinimg.com/originals/28/67/92/286792cc6be508df5dae05219534c88b.gif").override(500, 300).into(imageView);
            recyclerView.setAdapter(recyclerAdapter_training1);
        }

        getdata();
    }
    private void getdata() {
        List<String> listTitle= Arrays.asList("하이 니즈","점핑잭","서서 자전거 윗몸 일으키기","마운틴 클라이머","복부 크런치","발 뒤꿈치 터치","플랭크","서서 자전거 윗몸 일으키기","마운틴 클라이머",
                "복부 크런치","발 뒤꿈치 터치 ","플랭크","코브라 스트레칭","누워서 허리 비틀기","플랭크 위드 힙트위스트"
        );
        List<String> listContent=Arrays.asList("00:20","00:30","x 20","x 20","x 10","x 16","00:30","x 20","x 20","x 10",
                "x 16","00:30","00:20","00:20","00:20"
        );
        List<Integer> listResid=Arrays.asList(
                R.raw.highknee, //1하이니즈
                R.raw.jumping, //2점핑잭
                R.raw.standing, //3서서 자전거 윗몸 일으키기
                R.raw.mountain, //4 마운틴 클라이머
                R.raw.crunch, //5복부 크런치
                R.raw.heeltouch, //6발 뒤꿈치 터치
                R.raw.plank, //7플랭크
                R.raw.standing, //8서서 자전거 윗몸 일으키기
                R.raw.mountain, //9마운틴 클라이머
                R.raw.crunch, //10복부 크런치
                R.raw.heeltouch, //11발뒤꿈치 터치
                R.raw.plank, //12플랭크
                R.raw.cobra, //13코브라 스트레칭
                R.raw.huri, // 14누워서 트위스트 스트레칭 왼쪽
                R.raw.planktwist // 15 플랭크 위드 힙트위스트

        );
        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResid.get(i));
            recyclerAdapter_training1.addItem(data);
        }
        recyclerAdapter_training1.notifyDataSetChanged();
    }
}
