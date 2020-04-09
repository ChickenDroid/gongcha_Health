package gongcha_health.com.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;

import gongcha_health.com.Model.Traing_data;
import gongcha_health.com.R;

public class Abs_Adapter extends RecyclerView.Adapter<Abs_Adapter.ItemViewHolder> {
    /*  리사이클러뷰를 사용하는경우가 많이 있지만 abs 탭에서는 하나만 사용하므로 따로 어댑터를 안꼬이게 더만들음  */
    private ArrayList<Traing_data> listData = new ArrayList<>();
    @NonNull
    @Override
    public Abs_Adapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training2_listitem, parent, false);
        return new Abs_Adapter.ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Abs_Adapter.ItemViewHolder holder, final int position) {
        holder.onBind(listData.get(position));
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context=view.getContext();
                if(position==0){
                    /* source this library:  https://github.com/Shashank02051997/FancyGifDialog-Android   excellent library but setmessage is not worked (bug) */
                    new FancyGifDialog.Builder((Activity)context)
                            // .setMessage("abcdefghijklmnopqrstuvwxyz")현재 이라이브러리에 setmessage bug가있음
                            .setTitle("점핑잭\n\n 베이직 점핑잭 하나만으로도 칼로리 소비가 많지만\n이 운동은 동작을 조금씩 변형하면" +
                                    "근력운동도 함께되니 짧은 시간에 지방연소와 근육을 만들기 좋은 운동입니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.jumping)
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
                }else if(position==1 ||position==8){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("크런치 킥\n\n 이 자세를 할때 주의할점은 최대한 다리는 근육으로 팍 차올리는 느낌을 하는것이 중요하고 \n"+
                                    "다리를 최대한 곧게 피는것이 중요합니다")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.crunchkick)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=n6NYu9d7uwk"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==2||position==9){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("크로스 암 크런치\n\n 양손을 가슴에 모은상태로 누우세요\n"+
                                    "상체를 일으킵니다\n 동일한 동작을 반복하여 실시합니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.crossarmcrunch)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=wgaIH-0rvQw"));
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
                else if(position==3||position==10){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("러시안 트위스트\n\n 뱃살 체지방의 연소에도 도움이되고 복부의 근육발달에 효과적인 운동입니다\n"+
                                    "중앙의 복부와 옆구리에 있는 복사근 근육을 발달시켜 줍니다")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.russian_twist)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=wkD8rjkodUI"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                } else if(position==4||position==11){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("마운틴 클라이머\n\n 푸시업 자세에서, 한쪽 무릎을\n가슴쪽으로 구부리세요.\n가볍게 점프하듯 다리를 바꾸어 구부립니다."
                            +"\n이 동작은 전신근육과 심혈관에 좋은 영향을 줍니다.")
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
                } else if(position==5||position==12){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("할로우\n\n 무릎을 90도로 접어서 올리고\n 아래허리가 바닥에서 덜어지지 않게 눌러줍니다. \n 상체를 들어서 날개뼈를 바닥에서 떨어트립니다")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.hallow)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EQcp4PBJpqI"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==6||position==13){
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
                }else if(position==7){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("다리를 구부려 트위스트\n\n 바닥에 누워 두팔을 일직선이 되도록 뻗습니다\n 양발을 모아 다리를 수직으로 들어올립니다.\n 복부가 뒤틀리도록 발끝이 바닥에 닿기 전까지 사선방향으로 천천히내려줍니다. 시선은 다리의 반대방향입니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.reverse_trunk)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=eLFmcj7Hh1A"));
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
                            .setTitle("코브라 스트레칭\n\n 엎드려 누운 상태에서 두 손을 \n 어깨 밑에 놓고 팔꿈치를 굽힙니다.\n그리고 가슴을 바닥에서 최대한 멀리 밀어냅니다.이자세를\n몇초동안 유지하세요")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.cobra)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hR5RoEaVAFw"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==15){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("앉아서 복근 돌리기\n\n 양 팔꿈치를 뒤로 기대어 누워주세요 \n 두 다리를 모으고 발끝을 세워줍니다\n"+
                                    "다리를 붙여주고 들어주세요\n발끝에 원을 그리며 돌려주세요")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.seated_leg_circle)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=mu8T7C3CUw8&feature=emb_title"));
                                    context.startActivity(intent);
                                }
                            })
                            .OnNegativeClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                }
                            })
                            .build();
                }else if(position==16){
                    new FancyGifDialog.Builder((Activity)context)
                            .setTitle("플러터 킥\n\n 바닥에 누워 누운상태에서 상체와 다리를 올립니다\n" +
                                    "물장구 치듯 한발씩 올렷다 내렸다가 반복합니다.")
                            .setNegativeBtnText("취소")
                            .setPositiveBtnBackground("#FF4081")
                            .setPositiveBtnText("영상 보기")
                            .setNegativeBtnBackground("#FFA9A7A8")
                            .setGifResource(R.raw.flutter_kick)   //Pass your Gif here
                            .isCancellable(true)
                            .OnPositiveClicked(new FancyGifDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ofoNk4v-DSQ"));
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
