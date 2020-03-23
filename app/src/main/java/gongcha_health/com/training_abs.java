package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gongcha_health.com.Adapter.Abs_Adapter;
import gongcha_health.com.Adapter.batsal_Adapter;
import gongcha_health.com.Model.Traing_data;

public class training_abs extends AppCompatActivity {
    private Abs_Adapter recyclerAdapter_training2;
    boolean nodata =false;
    /*  트레이닝의 첫번째 뷰페이저의 리사이클러뷰 모든아이템의 모델   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_abs);
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
        TextView testtext1 = findViewById(R.id.abs_title);
        TextView testtext2 = findViewById(R.id.abs_text2);
        TextView textView=findViewById(R.id.abs_infor);
        testtext2.setText(content);
        testtext2.setTextColor(Color.parseColor("#000000"));
        RecyclerView recyclerView = findViewById(R.id.abs_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter_training2 = new Abs_Adapter();
        recyclerView.setAdapter(recyclerAdapter_training2);
        ActionBar actionBar=getSupportActionBar();
        if (nodata) {
            assert actionBar != null;
            actionBar.setTitle("휴식 일자");
            testtext1.setText("단단한 복근 만들기"+daycount+"일차 오늘은 푹 쉬세요");
            textView.setText("");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ImageView imageView = findViewById(R.id.abs_image);
            Glide.with(getBaseContext()).load("data:image/jpeg;base64,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").override(500, 300).into(imageView);
            testtext2.setText("당신의 몸과 근육이 휴식을 취해야 합니다.");
            testtext2.setTextSize(30);
            findViewById(R.id.abs_training_start).setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);

        } else {
            assert actionBar != null;
            actionBar.setTitle(title);
            testtext1.setText("단단한 복근 만들기"+daycount+"일차 마지막 까지 힘내세용");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ImageView imageView = findViewById(R.id.abs_image);
            /*  여기서 after_training_Batsal로 화면전환할때는 extra값 넘기거나 그냥첨부터 하이니즈로시작으로.  */
            findViewById(R.id.abs_training_start).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(training_abs.this,after_training_abs.class);
                    startActivity(intent);
                }
            });
            /*  이미지가 너무지겹기에 랜덤이벤트로 발생  */
            if(randomValue==0)
                Glide.with(getBaseContext()).load("https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2xMI/image/ICU6qfxsbXvAvwekloP2Z86joBI.gif").override(500, 300).into(imageView);
            else if(randomValue==1)
                Glide.with(getBaseContext()).load("https://lh3.googleusercontent.com/proxy/eZmgmtMgTQUOIWrm4m9hcQqs-mVcT_xM5_JdB0RvBfGJYQGmrkrht1E0x2BJiVqQLmKoMIusvUeWBqakun9qesa8w1xZYGmVrzXFKOU3mWibxOS1iLJFTx_XOWNwwYTPweExQnVRUnLof5ke5iB39fVF37QojMYTWSYmY99rzE73XiLpoOUT30dO6hKVetFK").override(500, 300).into(imageView);
            else if(randomValue==2)
                Glide.with(getBaseContext()).load("https://i.pinimg.com/originals/be/d8/55/bed855d846f5ff964d34186a92a75a4b.gif").override(500, 300).into(imageView);
            else if(randomValue==3)
                Glide.with(getBaseContext()).load("https://lh3.googleusercontent.com/proxy/HcLrDFZLiDa9-egyTJoDvqc3X4g7SDomXWt7CBJCdDPxX2bVsQQbR5GIkUuoJdJEhNRh0PFwTvzyA4bCKfJqmoEZ6u7urQQTlmEshkwCTAmzZps5DbakZ-cmU42jgCRA0Un41FEYwTAEdmIFz3WD16ZELWmAivYbAw").override(500, 300).into(imageView);
            else if(randomValue==4)
                Glide.with(getBaseContext()).load("https://24.media.tumblr.com/tumblr_m2q7tkTJXg1rtwwkxo1_500.gif").override(500, 300).into(imageView);
            else
                Glide.with(getBaseContext()).load("https://lh3.googleusercontent.com/proxy/87lVomN6MEAt1qpAFRukoD-KEPpz56mzuAVgKZiWXWYL_407hP3rUgOWCWqrxeU0M2XLYXw6_fYcaAJUMYcK0njOzRtRSu6NLlEWxGRHs2M6v3PXIP7qDB7daozkc_GK0hVOcwfrzhOw7gqo3uwc5bt_Rq5eOuHcTg").override(500, 300).into(imageView);
        }

        getdata();
    }
    private void getdata() {
        List<String> listTitle= Arrays.asList("점핑잭","크런치킥","크로스 암 크런치","러시안 트위스트","마운틴 클라이머","할로우","플랭크","다리를 구부려 트위스트","크런치킥",
                "크로스 암 크런치","러시안 트위스트","마운틴 클라이머","할로우","플랭크","코브라 스트레칭","앉아서 복근 돌리기","플러터 킥"
        );
        List<String> listContent=Arrays.asList("00:30","00:40","x 15","x 20","x 26","x 8","00:40","00:40","00:40","x 15",
                "x 20","x 26","x 8","00:40","00:40", "00:40","00:40"
        );
        //TODO 1 점핑잭
        //2 크런치킥
        //3 크로스 암 크런치
        //4 러시안 트위스트
        //5 마운틴 클라이머
        //6 할로우
        //7 플랭크
        //8 다리를구부려트위스트
        //9 크런치 킥
        //10 크로스암크런치
        //11 러시안트위스트
        //12 마운틴클라이머
        //13 할로우
        //14 플랭크
        //15 코브라동작
        //16 앉아서 복근 돌리기
        //17 플러터 발차기

        List<Integer> listResid=Arrays.asList(
                R.raw.jumping, //1점핑잭
                R.raw.crunchkick, //2크런치킥
                R.raw.crossarmcrunch, //3크로스 암 크런치
                R.raw.russian_twist, //4 러시안 트위스트
                R.raw.mountain, //5마운틴 클라이머
                R.raw.hallow, //6할로우
                R.raw.plank, //7플랭크
                R.raw.reverse_trunk, //8다리를 구부려 트위스트(리버스 트렁크트위스트)
                R.raw.crunchkick, //9크런치 킥
                R.raw.crossarmcrunch, //10 크로스암크런치
                R.raw.russian_twist, //11러시안 트위스트
                R.raw.mountain, //12마운틴 클라이머
                R.raw.hallow, //13할로우
                R.raw.plank, // 14플랭크
                R.raw.cobra, // 15 코브라
                R.raw.seated_leg_circle,//16 앉아서 복근돌리기(seated leg circle)
                R.raw.flutter_kick//17 플러터 발차기
        );
        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResid.get(i));
            recyclerAdapter_training2.addItem(data);
        }
        recyclerAdapter_training2.notifyDataSetChanged();
    }
}
