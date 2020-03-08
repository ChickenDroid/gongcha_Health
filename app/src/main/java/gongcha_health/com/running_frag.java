package gongcha_health.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import me.relex.circleindicator.CircleIndicator;

public class running_frag extends Fragment {

    private View view;
    Button btn_training1,btn_training2;
    Button btn_daily1,btn_daily2;
    Button btn_challenge1,btn_challenge2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.running, container, false);

        btn_training1 = (Button)view.findViewById(R.id.begin_btn);
        btn_training2 = (Button)view.findViewById(R.id.pro_btn);
        btn_daily1 = (Button)view.findViewById(R.id.daily_btn);
        btn_daily2 = (Button)view.findViewById(R.id.free_btn);
        btn_challenge1 = (Button)view.findViewById(R.id.time_btn);
        btn_challenge2 = (Button)view.findViewById(R.id.km_btn);

        this.SetListener();

        return view;
    }

    public void SetListener()
    {
        btn_training1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        btn_training2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        btn_daily1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        btn_daily2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        btn_challenge1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });

        btn_challenge2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
            }
        });
    }


}