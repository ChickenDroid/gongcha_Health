package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Locale;
import java.util.Random;


public class after_traning_Batsal extends AppCompatActivity {
    int nowstate=0;  //nowstate가 변경됨에따른 이미지 변경 및 타이머 변경
    private TextView text_timer;   //타이머 표시
    private TextView text_title;   //운동타이틀
    private CountDownTimer resttimer; //휴식타이머
    long tmp; //타임스케줄러 정지버튼눌렀을때를 위한 담기용.
    TextToSpeech tts;
    long millisInFuture=20*1000;
    String title="하이니즈";
    int cnt=0;
    CountDownTimer timer;
    ImageView pause,previous,next,video,information;  //정지,이전,다음,비디오,정보

    boolean nowrest=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_traning__batsal);

        final ImageView img=findViewById(R.id.batsal_mainIMG);
        Glide.with(getBaseContext()).load(R.raw.highknee).into(img);
        text_timer=findViewById(R.id.batsal_timer);
        text_title=findViewById(R.id.batsal_title);
        text_title.setText(title);
        previous=findViewById(R.id.batsal_previous);
        pause=findViewById(R.id.batsal_pause);
        next=findViewById(R.id.batsal_next);
        video=findViewById(R.id.video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(after_traning_Batsal.this, Detail_batsalvideo.class);
                intent.putExtra("titlename",text_title.getText());
                intent.putExtra("state","video");
                startActivity(intent);
            }
        });
        information=findViewById(R.id.batsal_information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(after_traning_Batsal.this, Detail_batsalanimation.class);
                intent.putExtra("titlename",text_title.getText());
                intent.putExtra("state",nowstate);
                startActivity(intent);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nowstate--;
                cnt=0;
                if (nowstate < 0)
                    ;
                else {
                    timer.cancel();
                    if (nowrest)
                        resttimer.onFinish();
                    else
                        nextstep();
                }
                next.setVisibility(View.VISIBLE);
            }
        });
        previous.setVisibility(View.INVISIBLE);

        /*   */
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cnt %2==0)
                {
                    timer.cancel();         /* 타이머는 정지기능이 없기에 현재 값을 매번 받아서  tmp에 받아온것을 토대로 새로 타이머를 설정해줘야할듯욤  */
                    millisInFuture=tmp;
                    cnt++;
                    Toast.makeText(after_traning_Batsal.this, "운동 타이머를 정지합니다", Toast.LENGTH_SHORT).show();
                }else{
                    cnt++;
                    timerstart();
                    Toast.makeText(after_traning_Batsal.this, "운동 타이머를 재개합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt=0;
                if (nowrest) {
                    resttimer.onFinish();
                } else {
                    if (nowstate >= 13) {
                        Toast.makeText(after_traning_Batsal.this, "다음 운동이 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(after_traning_Batsal.this, "다음 운동으로 진행합니다", Toast.LENGTH_SHORT).show();
                        resttimer.cancel();
                        timer.cancel(); //타이머태스크를 취소시킨후
                        nextstep();
                    }
                }

            }
        });


        /* TTS INIT */
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i !=TextToSpeech.ERROR)
                    tts.setLanguage(Locale.KOREAN);
                tts.speak(getString(R.string.high_Knees),TextToSpeech.QUEUE_FLUSH,null);// for highknee
            }
        });
        timerstart();
        /*  10초 휴식타이머 */
        resttimer=new CountDownTimer(10*1000,1000) {
            @Override
            public void onTick(long l) {
                text_timer.setText("00:"+(l/1000));
                /* 여기서는 pause할일 없을것 */
            }
            @Override
            public void onFinish() {
                nowrest=false;
                resttimer.cancel();
                if(nowstate==0){
                    Glide.with(getBaseContext()).load(R.raw.highknee).into(img);
                    text_title.setText("하이니즈");
                    previous.setVisibility(View.INVISIBLE);
                    tts.speak(getString(R.string.high_Knees), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==1) {
                    Glide.with(getBaseContext()).load(R.raw.jumping).into(img);
                    millisInFuture = 30 * 1000;
                    text_title.setText("점핑 잭");
                    tts.speak(getString(R.string.jumping_Jack), TextToSpeech.QUEUE_FLUSH, null);
                    Log.v("nowstate",""+nowstate);
                    Log.v("nowmillis",""+millisInFuture);
                } else if(nowstate==2||nowstate==7){
                    Glide.with(getBaseContext()).load(R.raw.standing).into(img);
                    text_title.setText("서서 자전거 윗몸 일으키기");
                    tts.speak(getString(R.string.standing_bicycle), TextToSpeech.QUEUE_FLUSH, null);
                }else if (nowstate==3||nowstate==8){
                    Glide.with(getBaseContext()).load(R.raw.mountain).into(img);
                    text_title.setText("마운틴 클라이머");
                    tts.speak(getString(R.string.standing_bicycle), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==4 ||nowstate==9){
                    Glide.with(getBaseContext()).load(R.raw.crunch).into(img);
                    text_title.setText("복부 크런치");
                    tts.speak(getString(R.string.crunch), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==5||nowstate==10){
                    Glide.with(getBaseContext()).load(R.raw.heeltouch).into(img);
                    text_title.setText("발 뒤꿈치 터치");
                    tts.speak(getString(R.string.HEEL_TOUCH), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==6){
                    Glide.with(getBaseContext()).load(R.raw.plank).into(img);
                    text_title.setText("플랭크");
                    tts.speak(getString(R.string.plank), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==11){
                    Glide.with(getBaseContext()).load(R.raw.cobra).into(img);
                    text_title.setText("코브라 스트레칭");
                    millisInFuture=20*1000;
                    tts.speak(getString(R.string.cobra), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==12){
                    Glide.with(getBaseContext()).load(R.raw.huri).into(img);
                    text_title.setText("누워서 트위스트");
                    tts.speak(getString(R.string.huri), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==13){
                    Glide.with(getBaseContext()).load(R.raw.planktwist).into(img);
                    text_title.setText("플랭크 위드 힙트위스트");
                    tts.speak(getString(R.string.planktwist), TextToSpeech.QUEUE_FLUSH, null);
                    next.setVisibility(View.INVISIBLE);
                }
                if(nowstate>13)
                    ; //NOTHING합시다.
                else {
                    findViewById(R.id.video).setVisibility(View.VISIBLE);
                    findViewById(R.id.batsal_information).setVisibility(View.VISIBLE);
                    timerstart();
                }
            }
        };
    }
    /* 휴식 */
    private void nextstep() {
        tmp=0;
        nowstate++;
        nowrest=true;
        Random random = new Random();
        int randomValue = random.nextInt(6);
         ImageView img=findViewById(R.id.batsal_mainIMG);
        findViewById(R.id.video).setVisibility(View.INVISIBLE);
        findViewById(R.id.batsal_information).setVisibility(View.INVISIBLE);
        /* 랜덤고양이 휴식시간 url로부르는게 약간의 공백시간이 있어서 다운받은후 raw에넣음. */
        if(randomValue==0)
         Glide.with(getBaseContext()).load(R.raw.catrest).into(img);
        else if (randomValue==1)
                Glide.with(getBaseContext()).load(R.raw.cat1).into(img);
        else if (randomValue==2)
            Glide.with(getBaseContext()).load(R.raw.cat2).into(img);
        else if (randomValue==3)
            Glide.with(getBaseContext()).load(R.raw.cat3).into(img);
        else if (randomValue==4)
            Glide.with(getBaseContext()).load(R.raw.cat4).into(img);
        else
            Glide.with(getBaseContext()).load(R.raw.cat5).into(img);
        text_title.setText("휴식");

        // Log.v("nextstep",""+nowstate);
      //  Log.v("nextmillis",""+millisInFuture);
        findViewById(R.id.batsal_previous).setVisibility(View.VISIBLE);
        if(nowstate>13)
            tts.speak("모든 운동을 마쳤습니다 수고하셨어요", TextToSpeech.QUEUE_FLUSH, null);
        else {
            tts.speak("10초간 휴식을 취하세요", TextToSpeech.QUEUE_FLUSH, null);
            resttimer.start();
        }
    }

    /* TTS정상종료처리 (메모리) */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }


    /* 메소드로 처리하는게 나을듯  oncreate로 처리할시 맘에안드는 문제가있음 시간별 문제가 있음. */
    public void timerstart(){
        //1초간격으로
        //운동타이머
         timer = new CountDownTimer(millisInFuture, 1000) {
            public void onTick(long second) {
                text_timer.setText("00:" + (second / 1000));
                tmp = second;
            }

            public void onFinish() {
                tts.speak("휴식 후 다음운동을 진행합니다.", TextToSpeech.QUEUE_FLUSH, null);
               nextstep();
            }
        };
        timer.start();
    }

}
