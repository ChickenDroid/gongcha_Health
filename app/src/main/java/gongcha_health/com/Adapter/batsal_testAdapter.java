package gongcha_health.com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gongcha_health.com.R;
import gongcha_health.com.Model.Traing_data;
import gongcha_health.com.Training_batsal;

public class batsal_testAdapter extends RecyclerView.Adapter<batsal_testAdapter.ItemViewHolder> {
    /*  리사이클러뷰를 사용하는경우가 너무나도많아서 따로 어댑터를 안꼬이게 더만들어야할듯  */
    private ArrayList<Traing_data> listData = new ArrayList<>();
    @NonNull
    @Override
    public batsal_testAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training1_listitem, parent, false);
        return new batsal_testAdapter.ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull batsal_testAdapter.ItemViewHolder holder, final int position) {
        holder.onBind(listData.get(position));
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Intent intent=new Intent(context, Training_batsal.class);

            }
        });
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }
    public void addItem(Traing_data data) {
        listData.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private View mview;
        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            mview=itemView;
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void onBind(Traing_data data) {
            textView1.setText(data.getTitle());
            textView2.setText(data.getContent());
            Glide.with(itemView.getContext()).load(data.getResId()).into(imageView);
        }
    }


}
