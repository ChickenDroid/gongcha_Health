package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_Absanimation extends AppCompatActivity {
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__absanimation);
        Bundle extra = getIntent().getExtras();
        assert extra != null;
        title=extra.getString("titlename");
        int tmp=extra.getInt("state");
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        TextView batsaltitle=findViewById(R.id.abs_animation_title);
        TextView batsalinfo=findViewById(R.id.abs_animation_information);
        ImageView batsalanim=findViewById(R.id.abs_animation_image);

        batsaltitle.setText(title);
        if(tmp==0)
        {
            Glide.with(getBaseContext()).load(R.raw.jumping_jackanim).into(batsalanim);
            batsalinfo.setText(R.string.jumping_Jack);
        }else if (tmp==1||tmp==8){
            Glide.with(getBaseContext()).load(R.raw.crunchkickanim).into(batsalanim);
            batsalinfo.setText(R.string.crunch_kick);
        }else if (tmp==2||tmp==9){
            Glide.with(getBaseContext()).load(R.raw.crossarmcrunchanim).into(batsalanim);
            batsalinfo.setText(R.string.cross_arm_crunch);
        }else if (tmp==3||tmp==10){
            Glide.with(getBaseContext()).load(R.raw.russian_twistanim).into(batsalanim);
            batsalinfo.setText(R.string.russian_twist);
        }else if (tmp==4||tmp==11){
            Glide.with(getBaseContext()).load(R.raw.mountainanim).into(batsalanim);
            batsalinfo.setText(R.string.mountain_climber);
        }else if (tmp==5||tmp==12){
            Glide.with(getBaseContext()).load(R.raw.hallowanim).into(batsalanim);
            batsalinfo.setText(R.string.hallow);
        }else if (tmp==6||tmp==13){
            Glide.with(getBaseContext()).load(R.raw.plankanim).into(batsalanim);
            batsalinfo.setText(R.string.plank);
        }else if (tmp==7){
            Glide.with(getBaseContext()).load(R.raw.reverse_trunkanim).into(batsalanim);
            batsalinfo.setText(R.string.reverse_truck);
        }else if (tmp==14){
            Glide.with(getBaseContext()).load(R.raw.cobraanim).into(batsalanim);
            batsalinfo.setText(R.string.cobra);
        }else if (tmp==15){
            Glide.with(getBaseContext()).load(R.raw.seated_leg_circleanim).into(batsalanim);
            batsalinfo.setText(R.string.seated_leg_circle);
        }else if(tmp==16){
            Glide.with(getBaseContext()).load(R.raw.flutter_kickanim).into(batsalanim);
            batsalinfo.setText(R.string.flutter_kick);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_animation, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button_toanimation:
                return true;
            case R.id.button_toanimation2:
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}