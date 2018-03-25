package com.example.chetan.campusrecruitmentsystem;


import java.util.Iterator;

public class StudentContact {
    int id;
    String name;
    String uname;
    String uid;
    String emailId;
    String contactNo;
    String password;
    String address;
    String ssc;
    String hsc;
    String grade;
    String skill;
    String companyName1;
    String companyEmail1;
    String companyName2;
    String companyEmail2;
    String companyName3;
    String companyEmail3;
    String companyName4;
    String companyEmail4;
    Integer jobId1;
    String jobName1;
    String jobType1;
    Boolean qualified1;
    Integer jobId2;
    String jobName2;
    String jobType2;
    Boolean qualified2;
    Integer jobId3;
    String jobName3;
    String jobType3;
    Boolean qualified3;
    Integer jobId4;
    String jobName4;
    String jobType4;
    Boolean qualified4;


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
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setSsc(String ssc)
    {
        this.ssc= ssc;
    }
    public void setHsc(String hsc)
    {
        this.hsc=hsc;
    }
    public void setGrade(String grade){this.grade=grade;}
    public void setSkill(String skill){
        this.skill =skill;
    }
    public void setJobId1(Integer jobId1){this.jobId1=jobId1;}
    public void setJobName1(String jobName1){this.jobName1=jobName1;}
    public void setJobType1(String jobType1){this.jobType1=jobType1;}

    public void setQualified1(Boolean qualified1) {
        this.qualified1 = qualified1;
    }

    public void setJobId2(Integer jobId2){this.jobId2=jobId2;}
    public void setJobName2(String jobName2){this.jobName2=jobName2;}
    public void setJobType2(String jobType2){this.jobType2=jobType2;}

    public void setQualified2(Boolean qualified2) {
        this.qualified2 = qualified2;
    }

    public void setJobId3(Integer jobId3){this.jobId3=jobId3;}
    public void setJobName3(String jobName3){this.jobName3=jobName3;}
    public void setJobType3(String jobType3){this.jobType3=jobType3;}

    public void setQualified3(Boolean qualified3) {
        this.qualified3 = qualified3;
    }

    public void setJobId4(Integer jobId4){this.jobId4=jobId4;}
    public void setJobName4(String jobName4){this.jobName4=jobName4;}
    public void setJobType4(String jobType4){this.jobType4=jobType4;}

    public void setQualified4(Boolean qualified4) {
        this.qualified4 = qualified4;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }

    public void setCompanyEmail1(String companyEmail1) {
        this.companyEmail1 = companyEmail1;
    }

    public void setCompanyEmail2(String companyEmail2) {
        this.companyEmail2 = companyEmail2;
    }

    public void setCompanyEmail3(String companyEmail3) {
        this.companyEmail3 = companyEmail3;
    }

    public void setCompanyEmail4(String companyEmail4) {
        this.companyEmail4 = companyEmail4;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName2 = companyName2;
    }

    public void setCompanyName3(String companyName3) {
        this.companyName3 = companyName3;
    }

    public void setCompanyName4(String companyName4) {
        this.companyName4 = companyName4;
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
    public String getAddress()
    {
        return this.address;
    }
    public String getSsc()
    {
        return this.ssc;
    }
    public String getHsc()
    {
        return this.hsc;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getSkill() {
        return this.skill;
    }
    public Integer getJobId1(){return this.jobId1;}
    public Integer getJobId2(){return this.jobId2;}
    public Integer getJobId3(){return this.jobId3;}

    public Integer getJobId4() {
        return this.jobId4;
    }

    public Boolean getQualified1() {
        return this.qualified1;
    }

    public Boolean getQualified2() {
        return this.qualified2;
    }

    public Boolean getQualified3() {
        return this.qualified3;
    }

    public Boolean getQualified4() {
        return this.qualified4;
    }

    public String getJobName1() {
        return this.jobName1;
    }

    public String getJobName2() {
        return this.jobName2;
    }

    public String getJobName3() {
        return this.jobName3;
    }

    public String getJobName4() {
        return this.jobName4;
    }

    public String getJobType1() {
        return this.jobType1;
    }

    public String getJobType2() {
        return this.jobType2;
    }

    public String getJobType3() {
        return this.jobType3;
    }

    public String getJobType4() {
        return this.jobType4;
    }


    public String getCompanyEmail1() {
        return this.companyEmail1;
    }

    public String getCompanyEmail2() {
        return this.companyEmail2;
    }

    public String getCompanyEmail3() {
        return this.companyEmail3;
    }

    public String getCompanyEmail4() {
        return this.companyEmail4;
    }

    public String getCompanyName1() {
        return this.companyName1;
    }

    public String getCompanyName2() {
        return this.companyName2;
    }

    public String getCompanyName3() {
        return this.companyName3;
    }

    public String getCompanyName4() {
        return this.companyName4;
    }
}

