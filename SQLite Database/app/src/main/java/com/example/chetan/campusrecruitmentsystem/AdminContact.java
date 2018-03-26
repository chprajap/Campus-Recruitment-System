package com.example.chetan.campusrecruitmentsystem;


public class AdminContact {
    int id;
    String name;
    String uname;
    String uid;
    String emailId;
    String contactNo;
    String password;
    String address;

    public void setId(int id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setUname(String uname)
    {
        this.uname = uname;
    }
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }
    public void setContactNo(String contactNo)
    {
        this.contactNo = contactNo;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getUname()
    {
        return this.uname;
    }
    public String getUid()
    {
        return this.uid;
    }
    public String getEmailId()
    {
        return this.emailId;
    }
    public String getContactNo()
    {
        return this.contactNo;
    }
    public String getPassword()
    {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }
}
