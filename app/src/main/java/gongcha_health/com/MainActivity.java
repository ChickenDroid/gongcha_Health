package gongcha_health.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private training_frag frag1;
    private running_frag frag2;
    private setting_frag frag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null){
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
        }
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.training:
                        setFrag(0);
                        break;
                    case R.id.running:
                        setFrag(1);
                        break;
                    case R.id.setting:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        frag1 = new training_frag();
        frag2 = new running_frag();
        frag3 = new setting_frag();
        setFrag(0); // first frag

    }
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                frag1=new training_frag();
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                frag2=new running_frag();
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                frag3=new setting_frag();
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }
}