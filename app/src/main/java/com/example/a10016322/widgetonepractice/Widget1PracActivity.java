package com.example.a10016322.widgetonepractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Widget1PracActivity extends AppCompatActivity {

    Switch aSwitch;
    EditText editText;
    TextView textView;
    SeekBar seekBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget1_prac);

        aSwitch = (Switch)(findViewById(R.id.switch_id));
        editText = (EditText)(findViewById(R.id.edit_id));
        textView = (TextView)(findViewById(R.id.textEdit_id));
        seekBar = (SeekBar)(findViewById(R.id.seekBar_id));
        button = (Button)(findViewById(R.id.button_id));

        textView.setTextColor(Color.BLACK);
        seekBar.setEnabled(false);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                    seekBar.setEnabled(false);
                else
                    seekBar.setEnabled(true);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setTextColor(Color.BLACK);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if((s.toString().toLowerCase()).equals("red"))
                    textView.setTextColor(Color.RED);
                if((s.toString().toLowerCase()).equals("blue"))
                    textView.setTextColor(Color.BLUE);
                if((s.toString().toLowerCase()).equals("green"))
                    textView.setTextColor(Color.GREEN);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prog = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>prog) {
                    button.setWidth(button.getWidth() + 2);
                    button.setHeight(button.getHeight() + 2);
                }
                else if(progress<prog) {
                    button.setWidth(button.getWidth() - 2);
                    button.setHeight(button.getHeight() - 2);
                }
                prog = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
