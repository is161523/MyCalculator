package local.is161518_is161523.mycalculator;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public static final short OP_DIV = 1;
    public static final short OP_MUL = 2;
    public static final short OP_MINUS = 3;
    public static final short OP_PLUS = 4;
    public final static String TAG = "MyCALC";
    private short option = 0;
    /*
    0=nothing
    1=div
    2=mul
    3=min
    4=plu
    */

    private boolean option_selected=false;
    private boolean number_pressed=false;
    private float textview_number=0;
    private float last_value = 0;

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"OnRestart()");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"OnDestroy()");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop()");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("last_value",last_value);
        editor.putFloat("textview_number",textview_number);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        last_value= prefs.getFloat("last_value",0);
        textview_number= prefs.getFloat("textview_number",0);

        Log.i(TAG,"lv: "+ Float.toString(last_value));

        set_TextView(textview_number);

        final Button btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 0);
            }
        });

        final Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 1);
            }
        });

        final Button btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 2);
            }
        });

        final Button btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 3);
            }
        });

        final Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 4);
            }
        });

        final Button btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 5);
            }
        });

        final Button btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 6);
            }
        });

        final Button btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 7);
            }
        });

        final Button btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 8);
            }
        });

        final Button btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberButton_pressed(v, 9);
            }
        });

        final Button btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operatorButton_pressed(v, OP_MUL);
            }
        });

        final Button btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operatorButton_pressed(v, OP_DIV);
            }
        });

        final Button btn_plu = (Button) findViewById(R.id.btn_plu);
        btn_plu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operatorButton_pressed(v, OP_PLUS);
            }
        });

        final Button btn_min = (Button) findViewById(R.id.btn_min);
        btn_min.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operatorButton_pressed(v, OP_MINUS);
            }
        });


        final Button btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate(v);
                last_value=0;
                reset_Button_Color();
            }
        });

        final Button btn_c = (Button) findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_c(v);
            }
        });


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

    public void set_TextView(float f){
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        tv_sum.setText(String.format("%.2f", f));
    }

    public void set_TextView(String s){
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        tv_sum.setText(s);
    }

    public void append_TextView(float f){
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        float temp = Float.parseFloat(tv_sum.getText().toString());
        tv_sum.setText(String.format("%.0f", temp));
        tv_sum.append(String.format("%.2f", f));
    }

    //set TextView according to which Number-Button was pressed.
    public void numberButton_pressed(View view, float number) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"Number-Button: " + number + " pressed! Lenght:" + tv_sum.length());

        if (option_selected || textview_number == 0 || !number_pressed) {
            try {
                set_TextView(number);
            } catch (NullPointerException e) {
                set_TextView(0);
            }
            option_selected = false;
            reset_Button_Color();
        } else if(tv_sum.length()<11) { //Calc only support 9 Chars)
            try {
                append_TextView(number);
            } catch (NullPointerException e) {
                set_TextView(0);
            }
        }
        number_pressed = true;
        Log.i(TAG,"TV_SUM:" + tv_sum.getText().toString());
        textview_number = Float.parseFloat(tv_sum.getText().toString());

    }

    //Setup for Calculation!
    public void operatorButton_pressed(View view, short operator){
        Log.i(TAG,"Operator-Button: " + operator + " pressed!");

        Button btn;
        reset_Button_Color();

        switch (operator){
            case OP_DIV:
                btn = (Button) findViewById(R.id.btn_div);
                btn.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                btn.setTextColor(Color.WHITE);
                break;
            case OP_MUL:
                btn = (Button) findViewById(R.id.btn_mul);
                btn.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                btn.setTextColor(Color.WHITE);
                break;
            case OP_MINUS:
                btn = (Button) findViewById(R.id.btn_min);
                btn.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                btn.setTextColor(Color.WHITE);
                break;
            case OP_PLUS:
                btn = (Button) findViewById(R.id.btn_plu);
                btn.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
                btn.setTextColor(Color.WHITE);
                break;
        }

        if(number_pressed && last_value != 0){ //If last Button was a number and last_value is not 0 go calculate
            calculate(view);
        }
        else{
            last_value = textview_number;
        }
        option = operator; //After Calculation set new operator
        option_selected=true;
        number_pressed=false;
    }

    public void calculate(View view){
        float calc_sum = 0;

        switch (option){
            case OP_DIV:
                if(textview_number==0){
                    set_TextView("Fehler");
                    textview_number=0;
                    last_value=0;
                }
                else{
                    calc_sum=last_value/textview_number;
                    set_TextView(calc_sum);
                }
                break;
            case OP_MUL:
                calc_sum=last_value*textview_number;
                set_TextView(calc_sum);
                break;
            case OP_MINUS:
                calc_sum=last_value-textview_number;
                set_TextView(calc_sum);
                break;
            case OP_PLUS:
                calc_sum=last_value+textview_number;
                set_TextView(calc_sum);
                break;
        }
        last_value=calc_sum;
        textview_number=calc_sum;
        option_selected=false;
        number_pressed=false;
    }

    private void reset_Button_Color() {
        Button btn_plu = (Button) findViewById(R.id.btn_plu);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_min = (Button) findViewById(R.id.btn_min);
        Button btn_div = (Button) findViewById(R.id.btn_div);

        btn_plu.getBackground().clearColorFilter();
        btn_plu.setTextColor(Color.BLACK);
        btn_mul.getBackground().clearColorFilter();
        btn_mul.setTextColor(Color.BLACK);
        btn_min.getBackground().clearColorFilter();
        btn_min.setTextColor(Color.BLACK);
        btn_div.getBackground().clearColorFilter();
        btn_div.setTextColor(Color.BLACK);
    }

    public void btn_c(View view) {
        last_value=0;
        textview_number=0;
        option_selected=false;
        number_pressed=false;
        set_TextView(0);
        reset_Button_Color();
        Log.i(TAG,"button C");
    }
}