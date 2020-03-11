package gongcha_health.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        List<String> listTitle= Arrays.asList("1 일째","2 일째","3 일째","4 일째","5 일째","6 일째","7 일째","8 일째","9일째",
                "10 일째","11 일째","12 일째","13 일째","14 일째","15 일째"
                );
        List<String> listContent=Arrays.asList("15 운동","15 운동","15 운동","휴식","15 운동","15 운동","15 운동","휴식","15 운동",
                "15 운동","15 운동","휴식","15 운동","15 운동","15 운동"
        );

        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            recyclerAdapter_training1.addItem(data);
        }
        recyclerAdapter_training1.notifyDataSetChanged();
    }

}
