package com.example.android.chattingapp;

public class userProfile {
    String username,userId;
    userProfile(){

    }
    userProfile(String a,String b){
        username=a;
        userId=b;
    }
    String getUsername(){
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
