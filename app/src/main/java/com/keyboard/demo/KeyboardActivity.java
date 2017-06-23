package com.keyboard.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class KeyboardActivity extends Activity {
    private Context ctx;
    private Activity act;
    private EditText edit, edit2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        ctx = this;
        act = this;

        edit = (EditText) this.findViewById(R.id.edit);
        edit2 = (EditText) this.findViewById(R.id.edit2);
        edit.setInputType(InputType.TYPE_NULL);

        edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inputback = edit.getInputType();
                new KeyboardUtil(act, ctx, edit).showKeyboard();
                edit.setInputType(inputback);
                return false;
            }
        });
        edit2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edit2.setText("");
                int inputback = edit2.getInputType();
                edit2.setInputType(InputType.TYPE_NULL);
                new KeyboardUtil(act, ctx, edit2).showKeyboard();
                edit2.setInputType(inputback);
                return false;
            }
        });

    }
}