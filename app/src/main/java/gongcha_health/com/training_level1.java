package gongcha_health.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gongcha_health.com.Adapter.RecyclerAdapter_training1;
import gongcha_health.com.Model.Traing_data;

public class training_level1 extends Fragment {
    private RecyclerAdapter_training1 recyclerAdapter_training1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.training_level1, container, false);
        ImageView imageView=view.findViewById(R.id.training_level1);
        Glide.with(this).load(R.drawable.batsal).into(imageView);
        RecyclerView recyclerView=view.findViewById(R.id.training1_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter_training1 =new RecyclerAdapter_training1();
        recyclerView.setAdapter(recyclerAdapter_training1);
        getdata();




        view.findViewById(R.id.training_level1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=rq5DqZxhQQo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

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
                listResid.add(R.drawable.ic_dumbbell);

        }






        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResid.get(i));
            recyclerAdapter_training1.addItem(data);
        }
        recyclerAdapter_training1.notifyDataSetChanged();
    }

}
