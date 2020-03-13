package gongcha_health.com.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;

import gongcha_health.com.MainActivity;
import gongcha_health.com.R;
import gongcha_health.com.Model.Traing_data;
import gongcha_health.com.Training_batsal;

public class batsal_testAdapter extends RecyclerView.Adapter<batsal_testAdapter.ItemViewHolder> {
    /*  리사이클러뷰를 사용하는경우가 많이 있지만 뱃살 탭에서는 하나만 사용하므로 따로 어댑터를 안꼬이게 더만들음  */
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
                final Context context=view.getContext();
                if(position==0){
                    /* source this library:  https://github.com/Shashank02051997/FancyGifDialog-Android   excellent library but setmessage is not worked (bug) */
                    new FancyGifDialog.Builder((Activity)context)
                           // .setMessage("abcdefghijklmnopqrstuvwxyz")현재 이라이브러리에 setmessage bug가있음
                            .setTitle("하이 니즈\n\n 무릎이 적어도 90도 각도가 될때까지 다리를 올리고 오른쪽 다리를 반복 앞뒤로 교대로 진행합니다.\n\n이 다리와 엉덩이를 위한" +
                                    "훌륭한 운동과 하체의 유연성을 향상시킬 수 있습니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.highknee)
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=C1x5ll-iTr0"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==1){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("점핑잭\n\n 베이직 점핑잭 하나만으로도 칼로리 소비가 많지만\n이 운동은 동작을 조금씩 변형하면" +
                                    "근력운동도 함께되니 짧은 시간에 지방연소와 근육을 만들기 좋은 운동입니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.jumping)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6FlhxTgdiEY"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==2 ||position==7){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("서서 자전거 윗몸 일으키기\n\n 두 발을 어깨 너비만큼 벌리고 서세요.\n 무릎을 반대편 팔꿈치로 가져오세요."+
                                    "시작 위치로 돌아가 다른쪽으로 운동을 반복하세요.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.standing)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=UfPPoPayOp4&feature=emb_title"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }
                else if(position==3 ||position==8){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("마운틴 클라이머\n\n 푸시업 자세에서, 한 쪽 무릎을 가슴쪽으로 구부리세요.\n가볍게 점프하듯 다리를 바꾸어 구부립니다 이" +
                                    "동작은 전신 근육과 심혈관에 좋은 영향을 줍니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.mountain)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=FbUCU__ecgs"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                } else if(position==4 ||position==9){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("복부 크런치\n\n 바닥에 누워서 무릎을 굽히고, 발바닥을 바닥에 밀착시킵니다.\n 양손을 머리나 귀에 대고 복부에 힘을주며 고개를 살짝들어줍니다." +
                                    "몸을 둥글게 말아 어깨가 10~20cm정도 떨어질때까지 상체를 들어줍니다\n 천천히 상복부에 긴장을 유지하며 원래자세로 돌아옵니다")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.crunch)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=KqnFav4Edvw"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                } else if(position==5 ||position==10){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("발 뒤꿈치 터치\n\n 바닥에 누워 다리를 굽히고 두 팔을 몸 양쪽에 쭉 핍니다. \n\n 상체를 바닥에서 약간 들어 올려 손을 번갈아 발꿈치에 닿게 합니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.heeltouch)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=84onrQXGs1A"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==6 ||position==11){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("플랭크\n\n 푸시업 준비동작으로 몸의 무게를 팔로 버티면 팔꿈치, 발가락, 복근과 어깨 근육을 강화하는데 도움이 됩니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.plank)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=B--6YfhmBGc"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==12){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("코브라 스트레칭\n\n 엎드려 누운 상태에서 두 손을 어깨 밑에 놓고 팔꿈치를 굽힙니다. \n\n 그리고 가슴을 바닥에서 최대한 멀리 밀어 냅니다. 이 자세를 몇초동안 유지하세용")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.cobra)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=gRyvAuRJaDg"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==13){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("누워서 허리 비틀기\n\n 바닥에 누워서 왼쪽다리의 무릎을 구부려 당긴후, 오른쪽 바닥 방향으로 넘겨줍니다. 그리고 오른손으로 무릎을 눌러 효과를 높입니다.\n" +
                                    "30초동안 반복 후 반대방향으로 진행하세요")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.huri)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tpYa8iCUtAw&feature=emb_title"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==14){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("플랭크 위드 힙트위스트\n\n 기본 자센느 플랭크 자세와 동일 \n골반을 양옆으로 흔들때 땅에 닿지 않도록 한다. \n 발꿈치의 위치가 흔들리지 않도록 한다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.planktwist)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=crs7XdW3exY&list=PLtjIwYbLghvD6BQWEgKFjz5h5RxfLuiYh&index=22"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
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
