package gongcha_health.com;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import gongcha_health.com.Adapter.ilboonAdapter;
import gongcha_health.com.Model.ilboondata;

public class ilboon_frag extends Fragment {

    private View view;
    RecyclerView recyclerView;
    ilboonAdapter adapter;
    String ilboon="https://www.naver.com/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ilboon_recycle, container, false);
        recyclerView=view.findViewById(R.id.recycle_1boon);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new ilboonAdapter();
        recyclerView.setAdapter(adapter);
        getData();
        return view;
    }
    private void getData(){
        Ilboonsoup ilboonsoupTask=new Ilboonsoup();
        ilboonsoupTask.execute();
    }
    private class Ilboonsoup extends AsyncTask<Void , Void, Void>{
        ArrayList<String> listTitle = new ArrayList<>();
        ArrayList<String> listUrl = new ArrayList<>();
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(ilboon).get();
                final Elements title = doc.select("div.cast_atc._PM_newsstand_rolling li.ca_item");
               // final Elements img = doc.select("");
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //제목
                        for(Element element: title) {
                            listTitle.add(element.text());
                        }
                        // 이미지정보
                //        for (Element element : img){
               //             listUrl.add(element.attr("src"));
              //          }

                        for (int i = 0; i < 10 ; i++) {
                            ilboondata data = new ilboondata();
                            data.setTitle(listTitle.get(i));
              //              data.setImageUrl(listUrl.get(i));
                            adapter.addItem(data);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}