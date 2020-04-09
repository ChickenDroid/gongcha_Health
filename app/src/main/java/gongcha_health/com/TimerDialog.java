package gongcha_health.com;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TimerDialog extends AlertDialog {

    private Context mContext;

    private String mContent;
    private TextView mTextTimer;
    private ITimerDialogListener mDigListener;

    //Button List
    private ArrayList<Button> btnList = new ArrayList<Button>();

    //control timer
    private int mTimeCount = 0;
    private int mTargetTimeCount;
    private final int WHAT_TIME = 11;

    private Handler mTimerHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case WHAT_TIME:
                    if(mTimeCount > mTargetTimeCount){
                        mDigListener.onTimeout();
                        dismiss();
                        return;
                    }

                    //UI Work
                    Log.d("ROSA", ""+mTimeCount);
                    mTextTimer.setText(""+(mTargetTimeCount - mTimeCount));
                    mTimeCount++;

                    mTimerHandler.sendEmptyMessageDelayed(WHAT_TIME, 1000);
                    break;
            }
        }
    };

    public TimerDialog(Context context, String content, int targetTime) {
        super(context);

        mContext = context;
        mContent = content;
        mTargetTimeCount = targetTime;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_dialog_layout);

        mTextTimer = (TextView)findViewById(R.id.timerdialog_timer);
        ((TextView)findViewById(R.id.timerdialog_content)).setText(mContent);

        createBtnLayout();
    }

    private void createBtnLayout(){
        //화면 사이즈
        Display display = ((WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        float width = (float)display.getWidth();

        LinearLayout btnLayout = (LinearLayout)findViewById(R.id.timerdialog_btn_layout);
        ViewGroup.LayoutParams layoutParams = btnLayout.getLayoutParams();
        layoutParams.width = (int)(width*0.7);  //화면 좌우 여백을 남기기 위해서 70%만 사용
        btnLayout.setLayoutParams(layoutParams);
        btnLayout.setWeightSum(btnList.size());

        for(int i = 0 ; i < btnList.size() ; i++){
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
            lParams.weight=1;

            Button tmpBtn = btnList.get(i);
            tmpBtn.setLayoutParams(lParams);

            btnLayout.addView(tmpBtn);
        }

        mTimerHandler.sendEmptyMessage(WHAT_TIME);
    }

    public void addButton(String text, View.OnClickListener btnListener){
        Button tmpBtn = new Button(mContext);
        tmpBtn.setText(text);
        tmpBtn.setOnClickListener(btnListener);

        btnList.add(tmpBtn);
    }

    public void setOnClickCancelButton(ITimerDialogListener listener){
        mDigListener = listener;
    }

    public interface ITimerDialogListener {
        public void onTimeout();
    }
}