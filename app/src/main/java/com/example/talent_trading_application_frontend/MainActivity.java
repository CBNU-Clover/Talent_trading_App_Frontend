package com.example.talent_trading_application_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.talent_trading_application_frontend.MemberFunction.LoginActivity;
import com.example.talent_trading_application_frontend.MemberFunction.RegisterMember;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button_register = (ImageButton) findViewById(R.id.Register_Button);
        ImageButton button_login = (ImageButton) findViewById(R.id.Login_Button);

        ImageButton button_chat = (ImageButton) findViewById(R.id.chat_button);

        ImageButton button_board = (ImageButton) findViewById(R.id.board_button);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegisterMember.class);
                startActivity(intent);
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}