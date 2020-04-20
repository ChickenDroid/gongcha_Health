package gongcha_health.com;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                count++;
            }
        });
    }
}
