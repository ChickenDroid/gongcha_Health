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
        List<String> listTitle= Arrays.asList("1일째","2일째","3일째","4일째","5일째","...");
        List<String> listContent=Arrays.asList("0%완료","0%완료","0%완료","0%완료","0%완료","...");

        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            recyclerAdapter_training1.addItem(data);
        }
        recyclerAdapter_training1.notifyDataSetChanged();
    }

}
