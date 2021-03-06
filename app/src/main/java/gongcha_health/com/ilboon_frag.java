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
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
    String ilboon3="https://1boon.kakao.com/p/search?q=%EC%9A%B4%EB%8F%99&cpKey=&sort=accuracy";
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
    private void refresh(){
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }
    private void getData(){
        Ilboonsoup ilboonsoupTask=new Ilboonsoup();
        ilboonsoupTask.execute();
    }
    private class Ilboonsoup extends AsyncTask<Void , Void, Void>{
        ArrayList<String> listTitle = new ArrayList<>();
        ArrayList<String> listUrl = new ArrayList<>();
        ArrayList<String> clickUrl=new ArrayList<>();
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(ilboon3).get();
                final Elements title = doc.select("div.info_classify strong");
                final Elements img = doc.select("img.img_thumb");
                final Elements click=doc.select("ul.list_classify.list_tag li a");
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
                     for(Element element:click){
                         clickUrl.add(element.attr("href"));

                     }
                        for (int i = 0; i < 20 ; i++) {
                            ilboondata data = new ilboondata();
                         //   Log.e("이미지는 어디간건대 ",listUrl.get(i).toString());
                            String url= listUrl.get(i);
                            int temp=url.lastIndexOf("=");
                           // Log.e("이미지는 어디간건대 ",url.substring(temp+1,url.length()));
                            data.setTitle(listTitle.get(i));
                            data.setImageUrl(url.substring(temp+1,url.length()));
                            data.setClickUrl(clickUrl.get(i));
                           // Log.e("clickurl값", clickUrl.get(i).toString());
                            // 제대로 값이 들어감을 확인
                            /* 2020 04 25 saechimdaeki*/
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