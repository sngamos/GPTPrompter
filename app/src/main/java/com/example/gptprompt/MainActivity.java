package com.example.gptprompt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText promptEditText;
    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        promptEditText = findViewById(R.id.promptEditText);
        Button sendButton = findViewById(R.id.sendButton);
        responseTextView = findViewById(R.id.responseTextView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prompt = promptEditText.getText().toString();
                new GPTRequest().sendGPTRequest(prompt, new GPTRequest.ResponseCallback() {
                    @Override
                    public void onResponse(String response) {
                        responseTextView.setText(response);
                    }

                    @Override
                    public void onFailure(String error) {
                        responseTextView.setText(error);
                    }
                });
            }
        });
    }
}
