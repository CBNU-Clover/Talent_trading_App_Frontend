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
        ImageButton mypage_btn = (ImageButton) findViewById(R.id.mypage_btn);
        ImageButton board_btn = (ImageButton) findViewById(R.id.board_btn);
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        board_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });


    }

}