package gongcha_health.com.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gongcha_health.com.Model.ilboondata;
import gongcha_health.com.R;

public class ilboonAdapter extends RecyclerView.Adapter<ilboonAdapter.ItemViewHolder> {
    private ArrayList<ilboondata> listData = new ArrayList<>();
    @Override
    public ilboonAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_training_all, viewGroup, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ilboonAdapter.ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.onBind(listData.get(i));
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }
    public void addItem(ilboondata data) {
        listData.add(data);
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView ilboontitle;
        private ImageView ilthumbnail;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ilboontitle = itemView.findViewById(R.id.ilboon_title);
            ilthumbnail     = itemView.findViewById(R.id.ilboon_thumbnail);
        }
        void onBind(ilboondata data){
            ilboontitle.setText(data.getTitle());
            Glide.with(itemView.getContext()).load(data.getImageUrl()).into(ilthumbnail);

        }
    }
}