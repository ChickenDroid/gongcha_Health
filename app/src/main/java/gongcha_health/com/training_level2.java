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

import java.util.ArrayList;
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
        List<String> listTitle=new ArrayList<String>();
        for(int i=0; i<15; i++)
        {
            String tmp;
            tmp=i+1+" 일째";
            listTitle.add(tmp);
        }
        List<String> listContent=new ArrayList<String>();
        for(int i=0; i<15; i++)
        {
            if(i==3||i==7 || i==11)
                listContent.add("휴식");
            else
                listContent.add("15 운동");
        }
        List<Integer> listResid=new ArrayList<Integer>();
        for(int i=0; i<15; i++)
        {
            if(i==3)
                listResid.add(R.drawable.ic_dumbbell);
            else if(i==7)
                listResid.add(R.drawable.ic_yoga);
            else if(i==11)
                listResid.add(R.drawable.ic_coffee_cup);
            else
                listResid.add(R.drawable.ic_dumbell2);

        }
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
