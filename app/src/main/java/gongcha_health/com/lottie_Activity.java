package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class lottie_Activity extends AppCompatActivity {
        int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_);
        final TextView txt=findViewById(R.id.textlottie);
        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("thirsty.json");
        animationView.playAnimation();
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                txt.setText("취소 버튼을 눌러 로딩을 스킵 할 수 있습니다.");
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                animationView.setVisibility(View.GONE);
                Toast.makeText(getApplication(),"썸네일 사진을 클릭하면 상세 페이지로 이동합니다. ", Toast.LENGTH_SHORT).show();

                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(getApplication(),"썸네일 사진을 클릭하면 상세 페이지로 이동합니다. ", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                count++;
            }
        });
    }
}
