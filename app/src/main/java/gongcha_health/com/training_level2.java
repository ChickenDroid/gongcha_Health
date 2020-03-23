package gongcha_health.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import gongcha_health.com.Adapter.RecyclerAdapter_training2;
import gongcha_health.com.Model.Traing_data;

public class training_level2 extends Fragment {
    private RecyclerAdapter_training2 recyclerAdapter_training2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.training_level2, container, false);
        ImageView img=view.findViewById(R.id.training_level2);
        Glide.with(this).load(R.drawable.physical_tst2).into(img);

        RecyclerView recyclerView=view.findViewById(R.id.training1_recyclerview2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter_training2 =new RecyclerAdapter_training2();
        recyclerView.setAdapter(recyclerAdapter_training2);
        getdata();
        return view;


    }
    private void getdata() {
        List<String> listTitle= Arrays.asList("1 일째","2 일째","3 일째","4 일째","5 일째","6 일째","7 일째","8 일째","9일째",
                "10 일째","11 일째","12 일째","13 일째","14 일째","15 일째");
        List<String> listContent=Arrays.asList("17 운동","17 운동","17 운동","휴식","17 운동","17 운동","17 운동","휴식","17 운동",
                "17 운동","17 운동","휴식","17 운동","17 운동","17 운동");
        List<Integer> listResid=Arrays.asList(
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_coffee_cup,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_yoga,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_coffee_cup,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2,
                R.drawable.ic_dumbell2

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
