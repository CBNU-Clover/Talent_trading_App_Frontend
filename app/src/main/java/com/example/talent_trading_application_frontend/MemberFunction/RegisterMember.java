package com.example.talent_trading_application_frontend.MemberFunction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_trading_application_frontend.R;
import com.example.talent_trading_application_frontend.domain.Member;
import com.example.talent_trading_application_frontend.retrofit.RegisterMemberApi;
import com.example.talent_trading_application_frontend.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterMember extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerMember();
    }
    public void registerMember()
    {
        EditText Name=findViewById(R.id.name);
        EditText Nickname=findViewById(R.id.password);
        EditText Email=findViewById(R.id.email);
        EditText Phone_number=findViewById(R.id.phone_number);
        EditText Password=findViewById(R.id.nickname);
        Button buttonSave=findViewById(R.id.registerButton);

        RetrofitService retrofitService=new RetrofitService();
        RegisterMemberApi registerMemberApi=retrofitService.getRetrofit().create(RegisterMemberApi.class);

        buttonSave.setOnClickListener(view -> {
            String name=String.valueOf(Name.getText());
            String nickname=String.valueOf(Nickname.getText());
            String email=String.valueOf(Email.getText());
            String phone_number=String.valueOf(Phone_number.getText());
            String password=String.valueOf(Password.getText());

            Member member=new Member();
            member.setName(name);
            member.setNickname(nickname);
            member.setEmail(email);
            member.setPhone_number(phone_number);
            member.setPassword(password);

            registerMemberApi.save(member)
                    .enqueue(new Callback<Member>() {
                        @Override
                        public void onResponse(Call<Member> call, Response<Member> response) {
                            Toast.makeText(RegisterMember.this, "Save successful!!!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<Member> call, Throwable t) {
                            Toast.makeText(RegisterMember.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(RegisterMember.class.getName()).log(Level.SEVERE,"Error occured",t);
                        }
                    });
        });
    }
}
