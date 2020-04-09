package gongcha_health.com;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import me.relex.circleindicator.CircleIndicator;

public class running_frag extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.running, container, false);

        ImageView training1_view = view.findViewById(R.id.training1);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2014/12/20/09/18/running-573762_960_720.jpg").into(training1_view);
        ImageView training2_view = view.findViewById(R.id.training2);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2016/11/14/03/38/achieve-1822503_960_720.jpg").into(training2_view);
        ImageView daily1_view = view.findViewById(R.id.daily1);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2019/05/18/14/42/jogging-4211946_960_720.jpg").into(daily1_view);
        ImageView daily2_view = view.findViewById(R.id.daily2);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2015/02/21/10/39/dog-644111_960_720.jpg").into(daily2_view);
        ImageView challenge1_view = view.findViewById(R.id.challenge1);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/11/10/05/24/clock-2935430_960_720.png").into(challenge1_view);
        ImageView challenge2_view = view.findViewById(R.id.challenge2);
        Glide.with(this).load("https://cdn.pixabay.com/photo/2017/08/24/21/41/tartan-track-2678544_960_720.jpg").into(challenge2_view);

        training1_view.setOnClickListener(new ImageView.OnClickListener(){
            public void onClick(View v){
                Intent intent = (new Intent(getActivity(),running_beginner.class));
                startActivity(intent);
            }
        });

        return view;
    }

}