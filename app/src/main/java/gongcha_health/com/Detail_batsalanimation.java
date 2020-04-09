package gongcha_health.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class Detail_batsalanimation extends AppCompatActivity {
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_batsalanimation);
        Bundle extra = getIntent().getExtras();
        assert extra != null;
        title=extra.getString("titlename");
        int tmp=extra.getInt("state");
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        TextView batsaltitle=findViewById(R.id.batsal_animation_title);
        TextView batsalinfo=findViewById(R.id.batsal_animation_information);
        ImageView batsalanim=findViewById(R.id.batsal_animation_image);

        batsaltitle.setText(title);
        if(tmp==0)
        {
            Glide.with(getBaseContext()).load(R.raw.highkneeanim).into(batsalanim);
            batsalinfo.setText(R.string.high_Knees);
        }else if (tmp==1){
            Glide.with(getBaseContext()).load(R.raw.jumping_jackanim).into(batsalanim);
            batsalinfo.setText(R.string.jumping_Jack);
        }else if (tmp==2||tmp==7){
            Glide.with(getBaseContext()).load(R.raw.standing_bicycleanim).into(batsalanim);
            batsalinfo.setText(R.string.standing_bicycle);
        }else if (tmp==3||tmp==8){
            Glide.with(getBaseContext()).load(R.raw.mountainanim).into(batsalanim);
            batsalinfo.setText(R.string.mountain_climber);
        }else if (tmp==4||tmp==9){
            Glide.with(getBaseContext()).load(R.raw.crunchanim).into(batsalanim);
            batsalinfo.setText(R.string.crunch);
        }else if (tmp==5||tmp==10){
            Glide.with(getBaseContext()).load(R.raw.heeltouchanim).into(batsalanim);
            batsalinfo.setText(R.string.HEEL_TOUCH);
        }else if (tmp==6){
            Glide.with(getBaseContext()).load(R.raw.plankanim).into(batsalanim);
            batsalinfo.setText(R.string.plank);
        }else if (tmp==11){
            Glide.with(getBaseContext()).load(R.raw.cobraanim).into(batsalanim);
            batsalinfo.setText(R.string.cobra);
        }else if (tmp==12){
            Glide.with(getBaseContext()).load(R.raw.hurianim).into(batsalanim);
            batsalinfo.setText(R.string.huri);
        }else if (tmp==13){
            Glide.with(getBaseContext()).load(R.raw.planktwistanim).into(batsalanim);
            batsalinfo.setText(R.string.planktwist);
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
