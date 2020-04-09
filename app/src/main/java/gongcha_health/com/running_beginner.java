package gongcha_health.com;

        import android.app.AppComponentFactory;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

public class running_beginner extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_beginner);
        Intent intent = getIntent();

        Button btn1_1 = (Button)findViewById(R.id.btn1_1);
        Button btn1_2 = (Button)findViewById(R.id.btn1_2);
        Button btn1_3 = (Button)findViewById(R.id.btn1_3);
        Button btn2_1 = (Button)findViewById(R.id.btn2_1);
        Button btn2_2 = (Button)findViewById(R.id.btn2_2);
        Button btn2_3 = (Button)findViewById(R.id.btn2_3);

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(35,"1주 1회차 - 몸풀기");
            }
        });
        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(39,"1주 2회차 - 스피드");
            }
        });
        btn1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(40,"1주 3회차 - 지구력");
            }
        });
        btn2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(35,"2주 1회차 - 스피드");
            }
        });
        btn2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(39,"2주 2회차 - 지구력");
            }
        });
        btn2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                transActivity(36,"2주 3회차 - 30분 달리기");
            }
        });

    }

    public void transActivity(int data,String context){
        Intent intent = new Intent(getApplicationContext(),running_timer.class);
        intent.putExtra("time",data);
        intent.putExtra("context",context);
        startActivity(intent);
    }


}
