package local.is161518_is161523.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MyCALC";
    private short option_selected = 0;
    private long last_value = 0;
    /*
    0=nothing
    1=div
    2=mul
    3=min
    4=plu
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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





    }

    public void btn_0(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 0");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("0");
            option_selected=0;
        }
        else{
            tv_sum.append("0");
        }


    }
    public void btn_1(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 1");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("1");
            option_selected=0;
        }
        else{
            tv_sum.append("1");
        }


    }
    public void btn_2(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 2");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("2");
            option_selected=0;
        }
        else{
            tv_sum.append("2");
        }

    }
    public void btn_3(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 3");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("3");
            option_selected=0;
        }
        else{
            tv_sum.append("3");
        }

    }
    public void btn_4(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 4");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("4");
            option_selected=0;
        }
        else{
            tv_sum.append("4");
        }

    }
    public void btn_5(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 5");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("5");
            option_selected=0;
        }
        else{
            tv_sum.append("5");
        }

    }
    public void btn_6(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 6");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("6");
            option_selected=0;
        }
        else{
            tv_sum.append("6");
        }

    }
    public void btn_7(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 7");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("7");
            option_selected=0;
        }
        else{
            tv_sum.append("7");
        }

    }
    public void btn_8(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 8");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("8");
            option_selected=0;
        }
        else{
            tv_sum.append("8");
        }

    }
    public void btn_9(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button 9");

        if(option_selected != 0) {
            last_value=Long.parseLong(tv_sum.getText().toString());
            tv_sum.setText("9");
            option_selected=0;
        }
        else{
            tv_sum.append("9");
        }

    }

    public void btn_div(View view) {
        Log.i(TAG,"button div");
        option_selected=1;

    }
    public void btn_mul(View view) {
        Log.i(TAG,"button mul");
        option_selected=2;

    }
    public void btn_min(View view) {
        Log.i(TAG,"button min");
        option_selected=3;

    }
    public void btn_plu(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button plu");
        option_selected=4;


    }
    public void btn_c(View view) {
        Log.i(TAG,"button C");

    }
    public void btn_sum(View view) {
        TextView tv_sum = (TextView) findViewById(R.id.tv_sum);
        Log.i(TAG,"button sum");
        long temp=0;
        if(option_selected==4) {
            temp = last_value + Long.parseLong(tv_sum.getText().toString());
        }
        tv_sum.setText(Long.toString(temp));


    }


}
