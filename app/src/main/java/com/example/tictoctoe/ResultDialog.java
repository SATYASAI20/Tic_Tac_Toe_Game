package com.example.tictoctoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultDialog extends Dialog {

    private final String message;
    private  final MainActivity mainActivity;

    private  Button exitButton, startAgainButton;
    TextView result_text ;

    public ResultDialog(@NonNull Context context, String message , MainActivity mainActivity){
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_result_dialog);
         result_text = findViewById(R.id.result_text);
         startAgainButton = findViewById(R.id.startAgainButton);
         exitButton = findViewById(R.id.exitButton);
         result_text.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.exit(0);
//                this.finishAffinity();
//                getOwnerActivity().finish();
                System.exit(0);
//                int pid = android.os.Process.myPid();
//                android.os.Process.killProcess(pid);

            }
        });
    }

}