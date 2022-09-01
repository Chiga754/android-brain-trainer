package com.example.braintrainer;

import android.view.View;
import android.widget.Toast;

public class BtnOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "test", Toast.LENGTH_LONG).show();
    }
}
