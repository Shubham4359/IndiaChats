package com.example.android.chattingapp;

public class firebasemodel {
    String name;
    String uid;
    String status;
    String image;
    firebasemodel(){

    }
    firebasemodel(String a,String b,String c,String d){
     name=a;
     image=b;
     uid=c;
     status=d;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getUid() {
        return uid;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
