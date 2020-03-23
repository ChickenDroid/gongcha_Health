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

public class after_training_abs extends AppCompatActivity {
    int nowstate=0;  //nowstate가 변경됨에따른 이미지 변경 및 타이머 변경
    private TextView text_timer;   //타이머 표시
    private TextView text_title;   //운동타이틀
    private CountDownTimer resttimer; //휴식타이머
    long tmp; //타임스케줄러 정지버튼눌렀을때를 위한 담기용.
    TextToSpeech tts;
    long millisInFuture=30*1000;
    String title="점핑잭";
    int cnt=0;
    CountDownTimer timer;
    long resttime=15*1000;
    long resttmp;
    ImageView pause,previous,next,video,information,moretime;  //정지,이전,다음,비디오,정보

    boolean nowrest=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_training_abs);

        final ImageView img=findViewById(R.id.abs_mainIMG);
        Glide.with(getBaseContext()).load(R.raw.jumping).into(img);
        text_timer=findViewById(R.id.abs_timer);
        text_title=findViewById(R.id.abs_title);
        text_title.setText(title);
        previous=findViewById(R.id.abs_previous);
        pause=findViewById(R.id.abs_pause);
        next=findViewById(R.id.abs_next);
        video=findViewById(R.id.absvideo);
        moretime=findViewById(R.id.abs_fifteen);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(after_training_abs.this, Detail_Absvideo.class);
                intent.putExtra("titlename",text_title.getText());
                intent.putExtra("state","video");
                startActivity(intent);
            }
        });
        information=findViewById(R.id.abs_information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(after_training_abs.this, Detail_Absanimation.class);
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
                    Toast.makeText(after_training_abs.this, "운동 타이머를 정지합니다", Toast.LENGTH_SHORT).show();
                }else{
                    cnt++;
                    timerstart();
                    Toast.makeText(after_training_abs.this, "운동 타이머를 재개합니다", Toast.LENGTH_SHORT).show();
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
                    if (nowstate >= 17) {
                        Toast.makeText(after_training_abs.this, "다음 운동이 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(after_training_abs.this, "다음 운동으로 진행합니다", Toast.LENGTH_SHORT).show();
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
                tts.speak(getString(R.string.jumping_Jack),TextToSpeech.QUEUE_FLUSH,null);// for highknee
            }
        });
        timerstart();
        /*  10초 휴식타이머 */
        resttimer=new CountDownTimer(resttime,1000) {
            @Override
            public void onTick(long l) {
                text_timer.setText("00:"+(l/1000));
                resttmp=l;
                /* 여기서는 pause할일 없을것 */
            }
            @Override
            public void onFinish() {
                nowrest=false;
                resttimer.cancel();
                if(nowstate==0){
                    Glide.with(getBaseContext()).load(R.raw.jumping).into(img);
                    text_title.setText("점핑잭");
                    previous.setVisibility(View.INVISIBLE);
                    tts.speak(getString(R.string.jumping_Jack), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==1||nowstate==8) {
                    Glide.with(getBaseContext()).load(R.raw.crunchkick).into(img);
                    millisInFuture = 40 * 1000;
                    text_title.setText("크런치 킥");
                    tts.speak(getString(R.string.crunch_kick), TextToSpeech.QUEUE_FLUSH, null);
                    Log.v("nowstate",""+nowstate);
                    Log.v("nowmillis",""+millisInFuture);
                } else if(nowstate==2||nowstate==9){
                    Glide.with(getBaseContext()).load(R.raw.crossarmcrunch).into(img);
                    text_title.setText("크로스 암 크런치");
                    tts.speak(getString(R.string.cross_arm_crunch), TextToSpeech.QUEUE_FLUSH, null);
                }else if (nowstate==3||nowstate==10){
                    Glide.with(getBaseContext()).load(R.raw.russian_twist).into(img);
                    text_title.setText("러시안 트위스트");
                    tts.speak(getString(R.string.russian_twist), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==4||nowstate==11){
                    Glide.with(getBaseContext()).load(R.raw.mountain).into(img);
                    text_title.setText("마운틴 클라이머");
                    tts.speak(getString(R.string.mountain_climber), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==5||nowstate==12){
                    Glide.with(getBaseContext()).load(R.raw.hallow).into(img);
                    text_title.setText("할로우");
                    tts.speak(getString(R.string.hallow), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==6||nowstate==13){
                    Glide.with(getBaseContext()).load(R.raw.plank).into(img);
                    text_title.setText("플랭크");
                    tts.speak(getString(R.string.plank), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==7){
                    Glide.with(getBaseContext()).load(R.raw.reverse_trunk).into(img);
                    text_title.setText("다리를 구부려 트위스트");
                    millisInFuture=40*1000;
                    tts.speak(getString(R.string.reverse_truck), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==14){
                    Glide.with(getBaseContext()).load(R.raw.cobra).into(img);
                    text_title.setText("코브라 스트레칭");
                    tts.speak(getString(R.string.cobra), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==15){
                    Glide.with(getBaseContext()).load(R.raw.seated_leg_circle).into(img);
                    text_title.setText("앉아서 복근 돌리기");
                    tts.speak(getString(R.string.seated_leg_circle), TextToSpeech.QUEUE_FLUSH, null);
                }else if(nowstate==16){
                    Glide.with(getBaseContext()).load(R.raw.flutter_kick).into(img);
                    text_title.setText("플러터 킥");
                    tts.speak(getString(R.string.flutter_kick), TextToSpeech.QUEUE_FLUSH, null);
                    next.setVisibility(View.INVISIBLE);
                }
                if(nowstate>17)
                    ; //NOTHING합시다.
                else {
                    findViewById(R.id.absvideo).setVisibility(View.VISIBLE);
                    findViewById(R.id.abs_information).setVisibility(View.VISIBLE);
                    pause.setVisibility(View.VISIBLE);
                    findViewById(R.id.abs_givemefifteen).setVisibility(View.INVISIBLE);
                    findViewById(R.id.abs_fifteen).setVisibility(View.INVISIBLE);
                    timerstart();
                }
            }
        };
        moretime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resttimer.cancel();
                resttmp+=15000;
                resttime=resttmp;
                resttimer.start();
            }
        });
    }
    /* 휴식 */
    private void nextstep() {
        tmp=0;
        nowstate++;
        nowrest=true;
        Random random = new Random();
        int randomValue = random.nextInt(7);
        ImageView img=findViewById(R.id.abs_mainIMG);
        findViewById(R.id.absvideo).setVisibility(View.INVISIBLE);
        findViewById(R.id.abs_information).setVisibility(View.INVISIBLE);
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
        else if (randomValue==5)
            Glide.with(getBaseContext()).load(R.raw.cat6).into(img);
        else
            Glide.with(getBaseContext()).load(R.raw.cat5).into(img);
        text_title.setText("휴식");

        // Log.v("nextstep",""+nowstate);
        //  Log.v("nextmillis",""+millisInFuture);
        findViewById(R.id.abs_previous).setVisibility(View.VISIBLE);
        if(nowstate>17)
            tts.speak("모든 운동을 마쳤습니다 수고하셨어요", TextToSpeech.QUEUE_FLUSH, null);
        else {
            tts.speak("휴식을 취하세요", TextToSpeech.QUEUE_FLUSH, null);
            pause.setVisibility(View.INVISIBLE);
            findViewById(R.id.abs_givemefifteen).setVisibility(View.VISIBLE);
            findViewById(R.id.abs_fifteen).setVisibility(View.VISIBLE);
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


    /*  비디오나 인포메이션 클릭했을때 타이머가 멈추고 다시 일시정지버튼누르면재개할수있게설정 */
    @Override
    protected  void onPause(){
        super.onPause();
        millisInFuture=tmp;
        cnt++;
        timer.cancel();
    }

    @Override
    protected  void onResume(){
        super.onResume();

    }

}
