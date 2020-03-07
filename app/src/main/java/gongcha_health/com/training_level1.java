package gongcha_health.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class training_level1 extends Fragment {
    private RecyclerAdapter_training recyclerAdapter_training;
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
        recyclerAdapter_training=new RecyclerAdapter_training();
        recyclerView.setAdapter(recyclerAdapter_training);
        getdata();
        return view;
    }

    private void getdata() {
        List<String> listTitle= Arrays.asList("1일째","2일째","3일째","4일째","5일째","...");
        List<String> listContent=Arrays.asList("0%완료","0%완료","0%완료","0%완료","0%완료","...");
        List<Integer> listResid=Arrays.asList(
                R.drawable.ic_abs,
                R.drawable.ic_diagram,
                R.drawable.ic_run,
                R.drawable.white_radius,
                R.drawable.ic_assignment_ind_black_24dp,
                R.drawable.ic_close_black_24dp

        );
        for (int i=0; i<listTitle.size(); i++){
            Traing_data data=new Traing_data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResid.get(i));
            recyclerAdapter_training.addItem(data);
        }
        recyclerAdapter_training.notifyDataSetChanged();
    }

}
