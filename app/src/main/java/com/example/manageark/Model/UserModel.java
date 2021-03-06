package com.example.manageark.Model;

import com.google.firebase.firestore.auth.User;

public class UserModel {
    private String uid;
    private String fullName;
    private String email;
    private String uniqueId;
    private String university;
    private String photoUrl;
    private String messID;

    public UserModel(){

    }

    public UserModel(String uid, String fullName, String email, String uniqueId, String university, String photoUrl,String messID) {
        this.uid = uid;
        this.fullName = fullName;
        this.email = email;
        this.uniqueId = uniqueId;
        this.university = university;
        this.photoUrl = photoUrl;
        this.messID = messID;
    }

    public String getMessID() {
        return messID;
    }

    public void setMessID(String messID) {
        this.messID = messID;
    }

    public void setUID(String uid) { this.uid = uid; }
    public String getUID() { return this.uid; }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniqueId() {
        return uniqueId;
    }
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid='" + uid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", university='" + university + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
