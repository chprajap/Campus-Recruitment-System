package com.example.chetan.campusrecruitmentsystem;

/**
 * Created by chetan on 3/10/18.
 */

public class User {
    private String mfullName,mUsername,mUserId,mEmailId,mContactNo,mAddress,mSSC,mHSC;
    public User()
    {
        //default
    }
    public User(String mfullName,String mUsername,String mUserId,String mEmailId,String mContactNo,String mAddress,String mSSC,String mHSC)
    {
        this.mfullName=mfullName;
        this.mUsername=mUsername;
        this.mUserId=mUserId;
        this.mEmailId=mEmailId;
        this.mContactNo=mContactNo;
        this.mAddress=mAddress;
        this.mSSC=mSSC;
        this.mHSC=mHSC;
    }

    /*public User getDetails()
    {

    }*/
}
