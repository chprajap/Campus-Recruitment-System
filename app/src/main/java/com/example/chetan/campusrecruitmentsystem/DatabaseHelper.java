package com.example.chetan.campusrecruitmentsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    /*private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "studentcontacts.db";
    private static final String TABLE_NAME  = "studentcontacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_EMAIL = "emailId";
    private static final String COLUMN_CONTACTNO= "contactNo";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_SSC = "ssc";
    private static final String COLUMN_HSC = "hsc";
    SQLiteDatabase db;
//    private static final String TABLE_CREATE = "create table studentcontacts (id integer primary key not null , name text not null , uname text , uid text not null , emailId text not null , contactNo text not null , password text not null);";

    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL , "+COLUMN_NAME+" TEXT NOT NULL , "+COLUMN_UNAME+" TEXT NOT NULL , "+COLUMN_UID+" TEXT NOT NULL , "+COLUMN_EMAIL+" TEXT NOT NULL , "+COLUMN_CONTACTNO+" TEXT NOT NULL , "+COLUMN_PASSWORD+" TEXT NOT NULL , " + COLUMN_ADDRESS + " TEXT NOT NULL , "+ COLUMN_SSC+" TEXT NOT NULL , "+COLUMN_HSC+" TEXT NOT NULL");";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    *//*public DatabaseHelper(Context context,int version)
    {
        super(context,DATABASE_NAME,null,version);
        *//**//*onUpgrade(db,DATABASE_VERSION,version);*//**//*
    }*/

    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "studentcontacts.db";
    private static final String TABLE_NAME  = "studentcontacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_EMAIL = "emailId";
    private static final String COLUMN_CONTACTNO= "contactNo";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_SSC = "ssc";
    private static final String COLUMN_HSC = "hsc";
    private static final String COLUMN_GRADE = "grade";
    private static final String COLUMN_SKILL = "skill";
    private static final String COLUMN_COMPANYNAME1 = "companyName1";
    private static final String COLUMN_COMPANYEMAIL1 = "companyEmail1";
    private static final String COLUMN_COMPANYNAME2 = "companyName2";
    private static final String COLUMN_COMPANYEMAIL2 = "companyEmail2";
    private static final String COLUMN_COMPANYNAME3 = "companyName3";
    private static final String COLUMN_COMPANYEMAIL3 = "companyEmail3";
    private static final String COLUMN_COMPANYNAME4 = "companyName4";
    private static final String COLUMN_COMPANYEMAIL4 = "companyEmail4";
    private static final String COLUMN_JOB_ID1= "jobId1";
    private static final String COLUMN_JOB_NAME1 = "jobName1";
    private static final String COLUMN_JOB_TYPE1 = "jobTYpe1";
    private static final String COLUMN_QUALIFIED1 = "qualified1";
    private static final String COLUMN_JOB_ID2= "jobId2";
    private static final String COLUMN_JOB_NAME2 = "jobName2";
    private static final String COLUMN_JOB_TYPE2 = "jobTYpe2";
    private static final String COLUMN_QUALIFIED2 = "qualified2";
    private static final String COLUMN_JOB_ID3= "jobId3";
    private static final String COLUMN_JOB_NAME3 = "jobName3";
    private static final String COLUMN_JOB_TYPE3 = "jobTYpe3";
    private static final String COLUMN_QUALIFIED3 = "qualified3";
    private static final String COLUMN_JOB_ID4= "jobId4";
    private static final String COLUMN_JOB_NAME4 = "jobName4";
    private static final String COLUMN_JOB_TYPE4 = "jobTYpe4";
    private static final String COLUMN_QUALIFIED4 = "qualified4";

    SQLiteDatabase db;
//    private static final String TABLE_CREATE = "create table studentcontacts (id integer primary key not null , name text not null , uname text , uid text not null , emailId text not null , contactNo text not null , password text not null);";

    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL , "+COLUMN_NAME+" TEXT NOT NULL , "+COLUMN_UNAME+" TEXT NOT NULL , "+COLUMN_UID+" TEXT NOT NULL , "+COLUMN_EMAIL+" TEXT NOT NULL , "+COLUMN_CONTACTNO+" TEXT NOT NULL , "+COLUMN_PASSWORD+" TEXT NOT NULL , " + COLUMN_ADDRESS + " TEXT NOT NULL , "+ COLUMN_SSC+" TEXT NOT NULL , "+COLUMN_HSC+" TEXT NOT NULL , "+COLUMN_GRADE+" TEXT , "+COLUMN_SKILL+" TEXT , "+
            COLUMN_COMPANYNAME1+" TEXT , "+COLUMN_COMPANYEMAIL1+" TEXT , "+COLUMN_JOB_ID1+" INTEGER , "+COLUMN_JOB_NAME1+" TEXT , "+COLUMN_JOB_TYPE1+" TEXT , "+COLUMN_QUALIFIED1+" BOOLEAN , "+COLUMN_COMPANYNAME2+" TEXT , "+COLUMN_COMPANYEMAIL2+" TEXT , "+COLUMN_JOB_ID2+" INTEGER , "+COLUMN_JOB_NAME2+" TEXT , "+COLUMN_JOB_TYPE2+" TEXT , "+COLUMN_QUALIFIED2+" BOOLEAN , "+
            COLUMN_COMPANYNAME3+" TEXT , "+COLUMN_COMPANYEMAIL3+" TEXT , "+COLUMN_JOB_ID3+" INTEGER , "+COLUMN_JOB_NAME3+" TEXT , "+COLUMN_JOB_TYPE3+" TEXT , "+COLUMN_QUALIFIED3+" BOOLEAN , "+COLUMN_COMPANYNAME4+" TEXT , "+COLUMN_COMPANYEMAIL4+" TEXT , "+COLUMN_JOB_ID4+" INTEGER , "+COLUMN_JOB_NAME4+" TEXT , "+COLUMN_JOB_TYPE4+" TEXT , "+COLUMN_QUALIFIED4+" BOOLEAN);";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
        Log.v("ov",String.valueOf(oldVersion));
        Log.v("nv",String.valueOf(newVersion));

        /*if(oldVersion<5)
        {
            db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN address text");
            db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN ssc text");
            db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN hsc text");
            this.onCreate(db);
        }*/
    }
 /*   public void insertStudentContact(StudentContact c)
    {
        db =this.getWritableDatabase();
        ContentValues values  = new ContentValues();

        String query  = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);

        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
        values.put(COLUMN_PASSWORD,c.getPassword());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPassword(String email)
    {
        db = this.getReadableDatabase();
        String query = "SELECT emailId, password FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a= cursor.getString(0);
                if(a.equals(email))
                {
                    b=cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;
    }

    public void updateProfile(StudentContact c)
    {
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
        values.put(COLUMN_PASSWORD,c.getPassword());
        values.put("address",c.getAddress());
        values.put("ssc",c.getSsc());
        values.put("hsc",c.getHsc());

        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                String.valueOf(c.getId())
        });
    }*/

    public void insertStudentContact(StudentContact c)
    {
        db =this.getWritableDatabase();
        ContentValues values  = new ContentValues();

        /*String query  = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);*/
        /*
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);*/

        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
        values.put(COLUMN_PASSWORD,c.getPassword());
        values.put(COLUMN_ADDRESS,"hello");
        values.put(COLUMN_SSC,"100");
        values.put(COLUMN_HSC,"100");
        c.setId((int) db.insert(TABLE_NAME,null,values));
        db.close();
    }

    public String searchPassword(String email)
    {
        db = this.getReadableDatabase();
        String query = "SELECT emailId, password FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a= cursor.getString(0);
                if(a.equals(email))
                {
                    b=cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;
    }

    public ArrayList<String> searchEmail(String email)
    {
        ArrayList<String> list = new ArrayList<>();
        db = this.getReadableDatabase();
        /*String query = "SELECT * FROM "+TABLE_NAME;*/
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_SSC,COLUMN_HSC,COLUMN_GRADE,COLUMN_SKILL,COLUMN_COMPANYNAME1,COLUMN_COMPANYEMAIL1,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_QUALIFIED1,COLUMN_COMPANYNAME2,COLUMN_COMPANYEMAIL2,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_QUALIFIED2,COLUMN_COMPANYNAME3,COLUMN_COMPANYEMAIL3,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_QUALIFIED3,COLUMN_COMPANYNAME4,COLUMN_COMPANYEMAIL4,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_QUALIFIED4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        list.add(cursor.getString(0));
        list.add(cursor.getString(1));
        list.add(cursor.getString(2));
        list.add(cursor.getString(3));
        list.add(cursor.getString(4));
        list.add(cursor.getString(5));
        list.add(cursor.getString(6));
        list.add(cursor.getString(7));
        list.add(cursor.getString(8));
        list.add(cursor.getString(9));

        /*String a,b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a= cursor.getString(4);
                if(a.equals(email))
                {
                    list.add(cursor.getString(0));
                    list.add(cursor.getString(1));
                    list.add(cursor.getString(2));
                    list.add(cursor.getString(3));
                    list.add(cursor.getString(4));
                    list.add(cursor.getString(5));
                    list.add(cursor.getString(6));
                    list.add(cursor.getString(7));
                    list.add(cursor.getString(8));
                    list.add(cursor.getString(9));

                    break;
                }

            }while(cursor.moveToNext());
        }*/
        return list;
    }

    public void updateProfile(StudentContact c)
    {
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
        values.put(COLUMN_PASSWORD,c.getPassword());
        values.put("address",c.getAddress());
        values.put("ssc",c.getSsc());
        values.put("hsc",c.getHsc());

        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                String.valueOf(c.getId())
        });
    }

    public void applyForJob(String email, String grade, String skill, String companyName, String companyEmail, Integer id, String name, String type,StudentContact c)
    {
        db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_SSC,COLUMN_HSC,COLUMN_GRADE,COLUMN_SKILL,COLUMN_COMPANYNAME1,COLUMN_COMPANYEMAIL1,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_QUALIFIED1,COLUMN_COMPANYNAME2,COLUMN_COMPANYEMAIL2,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_QUALIFIED2,COLUMN_COMPANYNAME3,COLUMN_COMPANYEMAIL3,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_QUALIFIED3,COLUMN_COMPANYNAME4,COLUMN_COMPANYEMAIL4,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_QUALIFIED4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            if(cursor.getString(10)==null)
            {
                ContentValues values = new ContentValues();
                values.put(COLUMN_GRADE,grade);
                values.put(COLUMN_SKILL,skill);
                values.put(COLUMN_COMPANYNAME1,companyName);
                values.put(COLUMN_COMPANYEMAIL1,companyEmail);
                values.put(COLUMN_JOB_ID1,id);
                values.put(COLUMN_JOB_NAME1,name);
                values.put(COLUMN_JOB_TYPE1,type);
                c.setJobId1(id);
                c.setJobName1(name);
                c.setJobType1(type);

                db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                        String.valueOf(c.getId())
                });
            }
            else
            {
                if(cursor.getString(18)==null)
                {
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_COMPANYNAME2,companyName);
                    values.put(COLUMN_COMPANYEMAIL2,companyEmail);
     /*               values.put(COLUMN_JOB_ID1,c.getJobId1());
                    values.put(COLUMN_JOB_NAME1,c.getJobName1());
                    values.put(COLUMN_JOB_TYPE1,c.getJobType1());
                    values.put(COLUMN_SALARY1,c.getSalary1());
     */               values.put(COLUMN_JOB_ID2,id);
                    values.put(COLUMN_JOB_NAME2,name);
                    values.put(COLUMN_JOB_TYPE2,type);
                    c.setJobId2(id);
                    c.setJobName2(name);
                    c.setJobType2(type);

                    db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                            String.valueOf(c.getId())
                    });
                }
                else
                {
                    if(cursor.getString(24)==null)
                    {
                        ContentValues values = new ContentValues();

                        values.put(COLUMN_COMPANYNAME3,companyName);
                        values.put(COLUMN_COMPANYEMAIL3,companyEmail);
                          values.put(COLUMN_JOB_ID3,id);
                        values.put(COLUMN_JOB_NAME3,name);
                        values.put(COLUMN_JOB_TYPE3,type);
                        c.setJobId3(id);
                        c.setJobName3(name);
                        c.setJobType3(type);

                        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                                String.valueOf(c.getId())
                        });
                    }
                    else
                    {
                        ContentValues values = new ContentValues();

                        values.put(COLUMN_COMPANYNAME4,companyName);
                        values.put(COLUMN_COMPANYEMAIL4,companyEmail);
         /*               values.put(COLUMN_JOB_ID1,c.getJobId1());
                        values.put(COLUMN_JOB_NAME1,c.getJobName1());
                        values.put(COLUMN_JOB_TYPE1,c.getJobType1());
                        values.put(COLUMN_SALARY1,c.getSalary1());
                        values.put(COLUMN_JOB_ID2,c.getJobId2());
                        values.put(COLUMN_JOB_NAME2,c.getJobName2());
                        values.put(COLUMN_JOB_TYPE2,c.getJobType2());
                        values.put(COLUMN_SALARY2,c.getSalary2());
                        values.put(COLUMN_JOB_ID3,c.getJobId3());
                        values.put(COLUMN_JOB_NAME3,c.getJobName3());
                        values.put(COLUMN_JOB_TYPE3,c.getJobType3());
                        values.put(COLUMN_SALARY3,c.getSalary3());
         */               values.put(COLUMN_JOB_ID4,id);
                        values.put(COLUMN_JOB_NAME4,name);
                        values.put(COLUMN_JOB_TYPE4,type);
                        c.setJobId4(id);
                        c.setJobName4(name);
                        c.setJobType4(type);

                        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                                String.valueOf(c.getId())
                        });
                    }
                }
            }
        }
    }

    // Getting All Shops
    public List<StudentContact> getAllStudent() {
        List<StudentContact> StudentList = new ArrayList<StudentContact>();
// Select All Query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Shop shop = new Shop();
                StudentContact c = new StudentContact();

                c.setId(Integer.parseInt(cursor.getString(0)));
                c.setName(cursor.getString(1));
                c.setEmailId(cursor.getString(4));
                c.setContactNo(cursor.getString(5));
                c.setAddress(cursor.getString(7));
                c.setSsc(cursor.getString(8));
                c.setHsc(cursor.getString(9));
                if(cursor.getString(10)!=null)
                {
                    c.setGrade(cursor.getString(10));
                    c.setSkill(cursor.getString(11));
                    c.setCompanyName1(cursor.getString(12));
                    c.setCompanyEmail1(cursor.getString(13));
                    c.setJobId1(Integer.parseInt(cursor.getString(14)));
                    c.setJobName1(cursor.getString(15));
                    c.setJobType1(cursor.getString(16));
                    c.setQualified1(Boolean.valueOf((cursor.getString(17))));

                    if(cursor.getString(18)!=null)
                    {
                        c.setCompanyName2(cursor.getString(18));
                        c.setCompanyEmail2(cursor.getString(19));
                        c.setJobId2(Integer.parseInt(cursor.getString(20)));
                        c.setJobName2(cursor.getString(21));
                        c.setJobType2(cursor.getString(22));
                        c.setQualified2(Boolean.valueOf((cursor.getString(23))));

                        if(cursor.getString(24)!=null)
                        {
                            c.setCompanyName3(cursor.getString(24));
                            c.setCompanyEmail3(cursor.getString(25));
                            c.setJobId3(Integer.parseInt(cursor.getString(26)));
                            c.setJobName3(cursor.getString(27));
                            c.setJobType3(cursor.getString(28));
                            c.setQualified3(Boolean.valueOf((cursor.getString(29))));
                            if(cursor.getString(30)!=null)
                            {
                                c.setCompanyName4(cursor.getString(30));
                                c.setCompanyEmail4(cursor.getString(31));
                                c.setJobId4(Integer.parseInt(cursor.getString(32)));
                                c.setJobName4(cursor.getString(33));
                                c.setJobType4(cursor.getString(34));
                                c.setQualified4(Boolean.valueOf((cursor.getString(35))));

                                StudentList.add(c);
                            }
                            else
                            {
                                StudentList.add(c);
                            }
                        }
                        else
                        {
                            StudentList.add(c);
                        }
                    }
                    else
                    {
                        StudentList.add(c);
                    }

                }
// Adding contact to list
                else
                {
                    StudentList.add(c);
                }
                /*shopList.add(shop);*/
            } while (cursor.moveToNext());
        }
// return contact list
        return StudentList;
    }

    public void changePassword(String password,String email,StudentContact c)
    {
        db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_SSC,COLUMN_HSC,COLUMN_GRADE,COLUMN_SKILL,COLUMN_COMPANYNAME1,COLUMN_COMPANYEMAIL1,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_QUALIFIED1,COLUMN_COMPANYNAME2,COLUMN_COMPANYEMAIL2,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_QUALIFIED2,COLUMN_COMPANYNAME3,COLUMN_COMPANYEMAIL3,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_QUALIFIED3,COLUMN_COMPANYNAME4,COLUMN_COMPANYEMAIL4,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_QUALIFIED4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            ContentValues values = new ContentValues();
            values.put(COLUMN_PASSWORD,password);
            db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                    String.valueOf(c.getId())
            });
        }
    }
}

    /*// Getting All Shops
    public List<Shop> getAllShops() {
        List<Shop> shopList = new ArrayList<Shop>();
// Select All Query
        String selectQuery = “SELECT * FROM ” + TABLE_SHOPS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Shop shop = new Shop();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setName(cursor.getString(1));
                shop.setAddress(cursor.getString(2));
// Adding contact to list
                shopList.add(shop);
            } while (cursor.moveToNext());
        }
// return contact list
        return shopList;
    }
*/
    /*public void deleteShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPS, KEY_ID + ” = ?”,
        new String[] { String.valueOf(shop.getId()) });
        db.close();
    }*/