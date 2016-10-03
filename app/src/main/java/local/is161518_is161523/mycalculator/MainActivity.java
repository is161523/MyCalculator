package local.is161518_is161523.mycalculator;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MyCALC";
    private short option = 0;
    private boolean option_selected=false;
    private boolean number_pressed=false;


    private long last_value = 0;
    /*
    0=nothing
    1=div
    2=mul
    3=min
    4=plu
    */

    @Override
    protected void onRestart(){
        super.onRestart();


        Log.i(TAG,"OnRestart()");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"OnDestroy()");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("last_value",last_value);
        editor.apply();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        last_value= prefs.getLong("last_value",last_value);

        Log.i(TAG,"lv: "+ Long.toString(last_value));


        final Button btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_0(v);
            }
        });

        final Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_1(v);
            }
        });

        final Button btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_2(v);
            }
        });

        final Button btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_3(v);
            }
        });

        final Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_4(v);
            }
        });

        final Button btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_5(v);
            }
        });

        final Button btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_6(v);
            }
        });

        final Button btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_7(v);
            }
        });

        final Button btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_8(v);
            }
        });

        final Button btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_9(v);
            }
        });
        final Button btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_mul(v);
            }
        });
        final Button btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_div(v);
            }
        });
        final Button btn_plu = (Button) findViewById(R.id.btn_plu);
        btn_plu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_plu(v);
            }
        });
        final Button btn_min = (Button) findViewById(R.id.btn_min);
        btn_min.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_min(v);
            }
        });
        final Button btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_sum(v);
            }
        });
        final Button btn_c = (Button) findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_c(v);
            }
        });

        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        tv_sum.setText(Long.toString(last_value));


        //Keep-Screen-On Button -> https://developer.android.com/training/scheduling/wakelock.html
        //ToggleButton -> https://developer.android.com/guide/topics/ui/controls/togglebutton.html
        final ToggleButton tb_kso = (ToggleButton) findViewById(R.id.tb_kso);
        tb_kso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.i(TAG,"KeepScreenOn = activated");
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                } else {
                    Log.i(TAG,"KeepScreenOn = deactivated");
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }
            }
        });


    }

    public void btn_0(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 0");

        if(option_selected) {
            tv_sum.setText("0");
            option_selected=false;
            reset_Button_Color();

        }
        else{
            tv_sum.append("0");
        }


    }
    public void btn_1(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 1");

        if(option_selected) {
            tv_sum.setText("1");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("1");
        }
        number_pressed=true;

    }
    public void btn_2(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 2");

        if(option_selected) {
            tv_sum.setText("2");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("2");
        }
        number_pressed=true;

    }
    public void btn_3(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 3");

        if(option_selected) {
            tv_sum.setText("3");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("3");
        }
        number_pressed=true;

    }
    public void btn_4(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 4");

        if(option_selected) {
            tv_sum.setText("4");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("4");
        }
        number_pressed=true;

    }
    public void btn_5(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 5");

        if(option_selected) {
            tv_sum.setText("5");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("5");
        }
        number_pressed=true;

    }
    public void btn_6(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 6");

        if(option_selected) {
            tv_sum.setText("6");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("6");
        }
        number_pressed=true;

    }
    public void btn_7(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 7");

        if(option_selected) {
            tv_sum.setText("7");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("7");
        }
        number_pressed=true;

    }
    public void btn_8(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 8");

        if(option_selected) {
            tv_sum.setText("8");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("8");
        }
        number_pressed=true;

    }
    public void btn_9(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 9");

        if(option_selected) {
                tv_sum.setText("9");
            option_selected=false;
            reset_Button_Color();
        }
        else{
            tv_sum.append("9");
        }
        number_pressed=true;

    }

    public void btn_div(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Log.i(TAG,"button div");

        reset_Button_Color();
        btn_div.setBackgroundResource(android.R.drawable.btn_star);
        try {
            if(tv_sum.getText().length() > 0 && last_value!=0 && number_pressed == true) {
                calc(Long.parseLong(tv_sum.getText().toString()));
            }else {
                last_value = Long.parseLong(tv_sum.getText().toString());
            }
        }catch (Exception x){}
        option=1;
        option_selected=true;
        number_pressed=false;

    }
    public void btn_mul(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Log.i(TAG,"button mul");

        reset_Button_Color();
        btn_mul.setBackgroundResource(android.R.drawable.btn_star);
        try {
            if(tv_sum.getText().length() > 0 && last_value!=0 && number_pressed == true) {
                calc(Long.parseLong(tv_sum.getText().toString()));
            }else {
                last_value = Long.parseLong(tv_sum.getText().toString());
            }
        }catch (Exception x){}
        option=2;
        option_selected=true;
        number_pressed=false;

    }
    public void btn_min(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Button btn_min = (Button) findViewById(R.id.btn_min);
        Log.i(TAG,"button min");

        reset_Button_Color();
        btn_min.setBackgroundResource(android.R.drawable.btn_star);
        try {
            if(tv_sum.getText().length() > 0 && last_value!=0 && number_pressed == true) {
                calc(Long.parseLong(tv_sum.getText().toString()));
            }else {
                last_value = Long.parseLong(tv_sum.getText().toString());
            }
        }catch (Exception x){}
        option=3;
        option_selected=true;
        number_pressed=false;


    }
    public void btn_plu(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Button btn_plu = (Button) findViewById(R.id.btn_plu);
        Log.i(TAG,"button plu=4");

        reset_Button_Color();
        btn_plu.setBackgroundResource(android.R.drawable.btn_star);
        try {
            if(tv_sum.getText().length() > 0 && last_value!=0 && number_pressed == true) {
                calc(Long.parseLong(tv_sum.getText().toString()));
            }else {
                last_value = Long.parseLong(tv_sum.getText().toString());
            }
        }catch (Exception x){}
        option=4;
        option_selected=true;
        number_pressed=false;


    }

    private void reset_Button_Color() {
        Button btn_plu = (Button) findViewById(R.id.btn_plu);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_min = (Button) findViewById(R.id.btn_min);
        Button btn_div = (Button) findViewById(R.id.btn_div);

        btn_plu.setBackgroundResource(android.R.drawable.btn_default);
        btn_mul.setBackgroundResource(android.R.drawable.btn_default);
        btn_min.setBackgroundResource(android.R.drawable.btn_default);
        btn_div.setBackgroundResource(android.R.drawable.btn_default);

    }


    public void btn_c(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        last_value=0;
        tv_sum.setText("");
        Log.i(TAG,"button C");
        option_selected=false;
        number_pressed=false;
        reset_Button_Color();

    }
    public void btn_sum(View view) {
        Log.i(TAG,"button sum");
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        long temp=0;

        switch (option){
            case 1:
                temp = last_value / Long.parseLong(tv_sum.getText().toString());
                last_value = temp;
                break;
            case 2:
                temp = last_value * Long.parseLong(tv_sum.getText().toString());
                last_value = temp;
                break;
            case 3:
                temp = last_value - Long.parseLong(tv_sum.getText().toString());
                last_value = temp;
                break;
            case 4:
                temp = last_value + Long.parseLong(tv_sum.getText().toString());
                last_value = temp;
                break;
        }

        tv_sum.setText(Long.toString(temp));
        number_pressed=false;
    }

    private void calc(long value){
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        long temp=0;

        switch (option){
            case 1:
                if(value != 0) {
                    temp = last_value / value;
                    last_value = temp;
                }
                break;
            case 2:
                temp = last_value * value;
                last_value=temp;
                break;
            case 3:
                temp = last_value - value;
                last_value=temp;
                break;
            case 4:
                temp = last_value + value;
                Log.i(TAG,"last_value: "+Long.toString(last_value));
                Log.i(TAG,"last: "+Long.toString(value));
                last_value=temp;
                break;
        }

        tv_sum.setText(Long.toString(temp));

    }


}
