package com.example.talent_trading_application_frontend.MemberFunction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_trading_application_frontend.MainActivity;
import com.example.talent_trading_application_frontend.R;
import com.example.talent_trading_application_frontend.domain.Member;
import com.example.talent_trading_application_frontend.dto.LoginDTO;
import com.example.talent_trading_application_frontend.retrofit.LoginApi;
import com.example.talent_trading_application_frontend.retrofit.RegisterMemberApi;
import com.example.talent_trading_application_frontend.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton backlogin = (ImageButton) findViewById(R.id backlogin);
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button register_btn = (Button) findViewById(R.id register_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterMember.class);
                startActivity(intent);
            }
        });

        Login();
    }

    private void Login() {
        EditText login_Nickname=findViewById(R.id.login_Nickname);
        EditText login_passWord=findViewById(R.id.login_passWord);
        Button login_button=findViewById(R.id.Login);
        RetrofitService retrofitService=new RetrofitService();

        LoginApi loginApi=retrofitService.getRetrofit().create(LoginApi.class);

        login_button.setOnClickListener(view -> {
        String Nickname=String.valueOf(login_Nickname.getText());
        String passWord=String.valueOf(login_passWord.getText());

            LoginDTO loginDTO=new LoginDTO();
            loginDTO.setNickname(Nickname);
            loginDTO.setPassWord(passWord);

            loginApi.login(loginDTO)
                    .enqueue(new Callback<LoginDTO>() {
                        @Override
                        public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                            Toast.makeText(LoginActivity.this, "Save successful!!!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<LoginDTO> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE,"Error occured",t);
                        }
                    });

    });

    }
}
