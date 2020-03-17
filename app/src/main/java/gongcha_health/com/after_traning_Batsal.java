package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;


public class after_traning_Batsal extends AppCompatActivity {
    int nowstate=0;  //nowstate가 변경됨에따른 이미지 변경 및 타이머 변경
    private TextView text_timer;   //타이머 표시
    private TextView text_title;   //운동타이틀
    private CountDownTimer resttimer; //휴식타이머
    long tmp; //타임스케줄러 정지버튼눌렀을때를 위한 담기용.
    TextToSpeech tts;
    int millisInFuture=20*1000;
    String title="하이니즈";
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_traning__batsal);
        final ImageView img=findViewById(R.id.batsal_mainIMG);
        Glide.with(getBaseContext()).load(R.raw.highknee).into(img);
        text_timer=findViewById(R.id.batsal_timer);
        text_title=findViewById(R.id.batsal_title);

        text_title.setText(title);
        /* TTS INIT */
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i !=TextToSpeech.ERROR)
                    tts.setLanguage(Locale.KOREAN);
                tts.speak(getString(R.string.high_Knees),TextToSpeech.QUEUE_ADD,null);//하이니즈만 이렇게하자.
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
                if(nowstate==1) {
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
                }
                findViewById(R.id.video).setVisibility(View.VISIBLE);
                findViewById(R.id.batsal_speak).setVisibility(View.VISIBLE);
                findViewById(R.id.batsal_information).setVisibility(View.VISIBLE);
                if(nowstate>13)
                    ; //NOTHING합시다.
                else
               timerstart();
            }
        };
    }
    private void nextstep() {
        tmp=0;
        nowstate++;
         ImageView img=findViewById(R.id.batsal_mainIMG);
        findViewById(R.id.video).setVisibility(View.INVISIBLE);
        findViewById(R.id.batsal_speak).setVisibility(View.INVISIBLE);
        findViewById(R.id.batsal_information).setVisibility(View.INVISIBLE);
         Glide.with(getBaseContext()).load("https://post-phinf.pstatic.net/MjAxOTAzMjVfMTg3/MDAxNTUzNDcyNDE4NDY1.u-KpcZ94JvOdnDk5hoPGVCSiwwWsHbeDTXbC8SwCTzgg.qiSNtp8y2hRGsZbLxKOa0VZbGKP6GRqHEBvpNus252Eg.GIF/02%EB%B0%B1%EC%88%98%EC%82%BC%EC%B4%8C%EB%83%A5.gif?type=w1200").into(img);
        text_title.setText("휴식");
       // Log.v("nextstep",""+nowstate);
      //  Log.v("nextmillis",""+millisInFuture);
        resttimer.start();
    }

    /* TTS정상종료처리 (메모리) */
    @Override
    protected void onStop() {
        super.onStop();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    /* 메소드로 처리하는게 나을듯  oncreate로 처리할시 맘에안드는 문제가있음 시간별 문제가 있음. */
    public void timerstart(){
        //1초간격으로
        //운동타이머
        CountDownTimer timer = new CountDownTimer(millisInFuture, 1000) {
            public void onTick(long second) {
                text_timer.setText("00:" + (second / 1000));
                tmp = (second / 1000);
            }

            public void onFinish() {
                tts.speak("휴식 후 다음운동을 진행합니다.", TextToSpeech.QUEUE_FLUSH, null);
                nextstep();
            }
        };
        timer.start();
    }

}
