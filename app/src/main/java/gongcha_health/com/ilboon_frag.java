package gongcha_health.com;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

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
    String ilboon3="https://1boon.kakao.com/p/search?q=%ED%99%88%ED%8A%B8%EB%A0%88%EC%9D%B4%EB%8B%9D&cpKey=&sort=accuracy";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ilboon_recycle, container, false);
        Intent intent=new Intent(getActivity(),lottie_Activity.class);
        startActivity(intent);

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
                Document doc = Jsoup.connect(ilboon3).get();
                final Elements title = doc.select("div.info_classify strong");// ilboon메인에서는 동작.. strong.tit_thumb span.inner_tit
                final Elements img = doc.select("img.img_thumb");
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for(Element element: title) {
                            listTitle.add(element.text());
                        }
                     for (Element element : img){
                           listUrl.add(element.attr("src"));
                       }
                        for (int i = 0; i < 20 ; i++) {
                            ilboondata data = new ilboondata();
                          //  Log.e("어이어이 ",listTitle.get(i));
                         //   Log.e("이미지는 어디간건대 ",listUrl.get(i).toString());
                            String url= listUrl.get(i);
                            int temp=url.lastIndexOf("=");
                          //  Log.e("temp값",Integer.toString(temp));
                           // Log.e("이미지는 어디간건대 ",url.substring(temp+1,url.length()));
                            data.setTitle(listTitle.get(i));
                            data.setImageUrl(url.substring(temp+1,url.length()));
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