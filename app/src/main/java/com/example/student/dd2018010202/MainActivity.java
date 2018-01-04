package com.example.student.dd2018010202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chk1;
    RadioGroup rg1;
    Switch sw;
    ProgressBar pb1;
    ProgressBar pb2;
    SeekBar sb;
    TextView tv2;

    int pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = (CheckBox) findViewById(R.id.checkBox);
        sw = (Switch) findViewById(R.id.switch1);
        pb1 = (ProgressBar) findViewById(R.id.progressBar);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv2 = (TextView) findViewById(R.id.textView2);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    Toast.makeText(MainActivity.this, "打勾了", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    pb1.setVisibility(View.VISIBLE);
                }
                else
                {
                    pb1.setVisibility(View.INVISIBLE);
                }
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv2.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void click1(View v)
    {
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        switch (rg1.getCheckedRadioButtonId())
        {
            case R.id.radioButton:
                Toast.makeText(MainActivity.this, "第一個按鈕", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(MainActivity.this, "第二個按鈕", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(MainActivity.this, "第三個按鈕", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this, "沒有選擇", Toast.LENGTH_SHORT).show();
                break;
        }

        Toast.makeText(MainActivity.this, String.valueOf(sb.getProgress()), Toast.LENGTH_SHORT).show();
    }

    public void click2(View v)
    {
        pb1.setVisibility(View.VISIBLE);

        new Thread()
        {
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb1.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();
    }

    public void click3(View v)
    {
        pb2.setProgress(pb2.getProgress() - 10);
    }

    public void click4(View v)
    {
        pb2.setProgress(pb2.getProgress() + 10);
    }

    public void clickGo(View v)
    {
        new Thread()
        {
            @Override
            public void run() {
                super.run();

                for (pi = 0; pi < 100; pi++)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pb2.setProgress(pi);
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }.start();
    }
}
