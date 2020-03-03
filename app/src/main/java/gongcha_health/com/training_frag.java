package gongcha_health.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import me.relex.circleindicator.CircleIndicator;

public class training_frag extends Fragment {

    private View view;
    ViewPager viewPager;
    private training_level1 fragment1;
    private training_level2 fragment2;
    private  training_level3 fragment3;
    /* 뷰페이저를 통해 근력운동의 레벨을 정할수있게함. */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.training, container, false);
        fragment1=new training_level1();
        fragment2=new training_level2();
        fragment3=new training_level3();
        viewPager=view.findViewById(R.id.training_viewpager);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        viewPager.setCurrentItem(0);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.training_indicator);
        indicator.setViewPager(viewPager);
        return view;
    }
    /*  뷰페이저에는 level 1,2,3의 단계가있음.   */
    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm){
            super(fm);
            getItem(0);
        }
        public Fragment getItem(int position){
            if(position==0)
            {
                return fragment1;
            }else if(position==1){
                return fragment2;
            }else {
                return fragment3;
            }
        }
        public int getCount(){
            return 3;
        }

    }
}