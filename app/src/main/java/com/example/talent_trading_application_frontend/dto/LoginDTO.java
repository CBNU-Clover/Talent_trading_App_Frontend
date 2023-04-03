package com.example.talent_trading_application_frontend.dto;

public class LoginDTO {
    private String nickname;
    private String passWord;

    public String getNickname() {
        return nickname;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
