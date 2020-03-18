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

public class RecyclerAdapter_training1 extends RecyclerView.Adapter<RecyclerAdapter_training1.ItemViewHolder> {
    private ArrayList<Traing_data> listData = new ArrayList<>();
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training1_listitem, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        holder.onBind(listData.get(position));
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Intent intent=new Intent(context, Training_batsal.class);
                if(position==0)
                {
                    intent.putExtra("title","뱃살 빼기 1일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==1){
                    intent.putExtra("title","뱃살 빼기 2일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==2){
                    intent.putExtra("title","뱃살 빼기 3일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==3){
                    intent.putExtra("title","뱃살 빼기 4일째");
                    intent.putExtra("content","휴식");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else   if(position==4)
                {
                    intent.putExtra("title","뱃살 빼기 5일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==5){
                    intent.putExtra("title","뱃살 빼기 6일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==6){
                    intent.putExtra("title","뱃살 빼기 7일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==7){
                    intent.putExtra("title","뱃살 빼기 8일째");
                    intent.putExtra("content","휴식");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else   if(position==8)
                {
                    intent.putExtra("title","뱃살 빼기 9일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==9){
                    intent.putExtra("title","뱃살 빼기 10일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==10){
                    intent.putExtra("title","뱃살 빼기 11일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==11){
                    intent.putExtra("title","뱃살 빼기 12일째");
                    intent.putExtra("content","휴식");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else   if(position==12)
                {
                    intent.putExtra("title","뱃살 빼기 13일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==13){
                    intent.putExtra("title","뱃살 빼기 14일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }else if(position==14){
                    intent.putExtra("title","뱃살 빼기 15일째");
                    intent.putExtra("content","운동 (15)");
                    intent.putExtra("daycount",position+1);
                    context.startActivity(intent);
                }
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
