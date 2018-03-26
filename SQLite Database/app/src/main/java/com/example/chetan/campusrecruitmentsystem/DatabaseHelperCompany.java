package com.example.chetan.campusrecruitmentsystem;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperCompany extends SQLiteOpenHelper {

    /*private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "companycontacts.db";
    private static final String TABLE_NAME = "companycontacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_EMAIL = "emailId";
    private static final String COLUMN_CONTACTNO= "contactNo";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY , "+COLUMN_NAME+" TEXT , "+COLUMN_UNAME+" TEXT , "+COLUMN_UID+" TEXT , "+COLUMN_EMAIL+" TEXT , "+COLUMN_CONTACTNO+" TEXT , "+COLUMN_PASSWORD+" TEXT );";
    public DatabaseHelperCompany(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
*/
    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "companycontacts.db";
    private static final String TABLE_NAME = "companycontacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_EMAIL = "emailId";
    private static final String COLUMN_CONTACTNO= "contactNo";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_RANK = "rank";
    private static final String COLUMN_JOB_ID1= "jobId1";
    private static final String COLUMN_JOB_NAME1 = "jobName1";
    private static final String COLUMN_JOB_TYPE1 = "jobTYpe1";
    private static final String COLUMN_SALARY1 = "salary1";
    private static final String COLUMN_JOB_ID2= "jobId2";
    private static final String COLUMN_JOB_NAME2 = "jobName2";
    private static final String COLUMN_JOB_TYPE2 = "jobTYpe2";
    private static final String COLUMN_SALARY2 = "salary2";
    private static final String COLUMN_JOB_ID3= "jobId3";
    private static final String COLUMN_JOB_NAME3 = "jobName3";
    private static final String COLUMN_JOB_TYPE3 = "jobTYpe3";
    private static final String COLUMN_SALARY3 = "salary3";
    private static final String COLUMN_JOB_ID4= "jobId4";
    private static final String COLUMN_JOB_NAME4 = "jobName4";
    private static final String COLUMN_JOB_TYPE4 = "jobTYpe4";
    private static final String COLUMN_SALARY4 = "salary4";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL , "+COLUMN_NAME+" TEXT NOT NULL , "+COLUMN_UNAME+" TEXT NOT NULL , "+COLUMN_UID+" TEXT NOT NULL , "+COLUMN_EMAIL+" TEXT NOT NULL , "+COLUMN_CONTACTNO+" TEXT NOT NULL , "+COLUMN_PASSWORD+" TEXT NOT NULL , "+COLUMN_ADDRESS+" TEXT NOT NULL , "+COLUMN_RANK+" TEXT NOT NULL , " +
            COLUMN_JOB_ID1+" INTEGER , "+COLUMN_JOB_NAME1+" TEXT , "+COLUMN_JOB_TYPE1+" TEXT , "+COLUMN_SALARY1+" INTEGER , "+COLUMN_JOB_ID2+" INTEGER , "+COLUMN_JOB_NAME2+" TEXT , "+COLUMN_JOB_TYPE2+" TEXT , "+COLUMN_SALARY2+" INTEGER , "+
            COLUMN_JOB_ID3+" INTEGER , "+COLUMN_JOB_NAME3+" TEXT , "+COLUMN_JOB_TYPE3+" TEXT , "+COLUMN_SALARY3+" INTEGER , "+COLUMN_JOB_ID4+" INTEGER , "+COLUMN_JOB_NAME4+" TEXT , "+COLUMN_JOB_TYPE4+" TEXT , "+COLUMN_SALARY4+" INTEGER);";
    public DatabaseHelperCompany(Context context)
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
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

/*    public void insertCompanyContact(CompanyContact c)
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
    }*/
public void insertCompanyContact(CompanyContact c)
{
    db =this.getWritableDatabase();
    ContentValues values  = new ContentValues();

    /*String query  = "SELECT * FROM "+TABLE_NAME;
    Cursor cursor = db.rawQuery(query,null);
    int count = cursor.getCount();

    values.put(COLUMN_ID,count);
*/
    values.put(COLUMN_NAME,c.getName());
    values.put(COLUMN_UNAME,c.getUname());
    values.put(COLUMN_UID,c.getUid());
    values.put(COLUMN_EMAIL,c.getEmailId());
    values.put(COLUMN_CONTACTNO,c.getContactNo());
    values.put(COLUMN_PASSWORD,c.getPassword());
    values.put(COLUMN_ADDRESS,"address");
    values.put(COLUMN_RANK,"rank");
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
        /*Cursor cursor = db.rawQuery(query,null);*/

        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_RANK,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_SALARY1,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_SALARY2,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_SALARY3,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_SALARY4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
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

       /* String a,b="not found";
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

                    break;
                }

            }while(cursor.moveToNext());
        }*/
        return list;
    }

    public void updateCompanyProfile(CompanyContact c)
    {
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
       // values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
       // values.put(COLUMN_PASSWORD,c.getPassword());
        values.put("address",c.getAddress());
        values.put("rank",c.getRank());

        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                String.valueOf(c.getId())
        });
    }

    public void postJobs(String email, Integer id, String name, String type, Integer salary,CompanyContact c)
    {
        ArrayList<String> list = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_RANK,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_SALARY1,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_SALARY2,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_SALARY3,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_SALARY4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            if(cursor.getString(9)==null)
            {
                ContentValues values = new ContentValues();
                values.put(COLUMN_NAME,c.getName());
                values.put(COLUMN_UNAME,c.getUname());
                values.put(COLUMN_UID,c.getUid());
                values.put(COLUMN_EMAIL,c.getEmailId());
                values.put(COLUMN_CONTACTNO,c.getContactNo());
                values.put(COLUMN_PASSWORD,c.getPassword());
                values.put(COLUMN_ADDRESS,c.getAddress());
                values.put(COLUMN_RANK,c.getRank());
                values.put(COLUMN_JOB_ID1,id);
                values.put(COLUMN_JOB_NAME1,name);
                values.put(COLUMN_JOB_TYPE1,type);
                values.put(COLUMN_SALARY1,salary);
                c.setJobId1(id);
                c.setJobName1(name);
                c.setJobType1(type);
                c.setSalary1(salary);

                db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                        String.valueOf(c.getId())
                });
            }
            else
            {
                if(cursor.getString(13)==null)
                {
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_NAME,c.getName());
                    values.put(COLUMN_UNAME,c.getUname());
                    values.put(COLUMN_UID,c.getUid());
                    values.put(COLUMN_EMAIL,c.getEmailId());
                    values.put(COLUMN_CONTACTNO,c.getContactNo());
                    values.put(COLUMN_PASSWORD,c.getPassword());
                    values.put(COLUMN_ADDRESS,c.getAddress());
                    values.put(COLUMN_RANK,c.getRank());
     /*               values.put(COLUMN_JOB_ID1,c.getJobId1());
                    values.put(COLUMN_JOB_NAME1,c.getJobName1());
                    values.put(COLUMN_JOB_TYPE1,c.getJobType1());
                    values.put(COLUMN_SALARY1,c.getSalary1());
     */               values.put(COLUMN_JOB_ID2,id);
                    values.put(COLUMN_JOB_NAME2,name);
                    values.put(COLUMN_JOB_TYPE2,type);
                    values.put(COLUMN_SALARY2,salary);
                    c.setJobId2(id);
                    c.setJobName2(name);
                    c.setJobType2(type);
                    c.setSalary2(salary);

                    db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                            String.valueOf(c.getId())
                    });
                }
                else
                {
                    if(cursor.getString(17)==null)
                    {
                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME,c.getName());
                        values.put(COLUMN_UNAME,c.getUname());
                        values.put(COLUMN_UID,c.getUid());
                        values.put(COLUMN_EMAIL,c.getEmailId());
                        values.put(COLUMN_CONTACTNO,c.getContactNo());
                        values.put(COLUMN_PASSWORD,c.getPassword());
                        values.put(COLUMN_ADDRESS,c.getAddress());
                        values.put(COLUMN_RANK,c.getRank());
       /*                 values.put(COLUMN_JOB_ID1,c.getJobId1());
                        values.put(COLUMN_JOB_NAME1,c.getJobName1());
                        values.put(COLUMN_JOB_TYPE1,c.getJobType1());
                        values.put(COLUMN_SALARY1,c.getSalary1());
                        values.put(COLUMN_JOB_ID2,c.getJobId2());
                        values.put(COLUMN_JOB_NAME2,c.getJobName2());
                        values.put(COLUMN_JOB_TYPE2,c.getJobType2());
                        values.put(COLUMN_SALARY2,c.getSalary2());
       */                 values.put(COLUMN_JOB_ID3,id);
                        values.put(COLUMN_JOB_NAME3,name);
                        values.put(COLUMN_JOB_TYPE3,type);
                        values.put(COLUMN_SALARY3,salary);
                        c.setJobId3(id);
                        c.setJobName3(name);
                        c.setJobType3(type);
                        c.setSalary3(salary);

                        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                                String.valueOf(c.getId())
                        });
                    }
                    else
                    {
                        ContentValues values = new ContentValues();
                        values.put(COLUMN_NAME,c.getName());
                        values.put(COLUMN_UNAME,c.getUname());
                        values.put(COLUMN_UID,c.getUid());
                        values.put(COLUMN_EMAIL,c.getEmailId());
                        values.put(COLUMN_CONTACTNO,c.getContactNo());
                        values.put(COLUMN_PASSWORD,c.getPassword());
                        values.put(COLUMN_ADDRESS,c.getAddress());
                        values.put(COLUMN_RANK,c.getRank());
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
                        values.put(COLUMN_SALARY4,salary);
                        c.setJobId4(id);
                        c.setJobName4(name);
                        c.setJobType4(type);
                        c.setSalary4(salary);

                        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                                String.valueOf(c.getId())
                        });
                    }
                }
            }
        }
    }

    public void changePassword(String password,String email,CompanyContact c)
    {
        db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS,COLUMN_RANK,COLUMN_JOB_ID1,COLUMN_JOB_NAME1,COLUMN_JOB_TYPE1,COLUMN_SALARY1,COLUMN_JOB_ID2,COLUMN_JOB_NAME2,COLUMN_JOB_TYPE2,COLUMN_SALARY2,COLUMN_JOB_ID3,COLUMN_JOB_NAME3,COLUMN_JOB_TYPE3,COLUMN_SALARY3,COLUMN_JOB_ID4,COLUMN_JOB_NAME4,COLUMN_JOB_TYPE4,COLUMN_SALARY4},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
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

     // Getting All Shops
    public List<CompanyContact> getAllCompany() {
        List<CompanyContact> companyList = new ArrayList<CompanyContact>();
// Select All Query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Shop shop = new Shop();
                CompanyContact c = new CompanyContact();

                c.setId(Integer.parseInt(cursor.getString(0)));
                c.setName(cursor.getString(1));
                c.setUname(cursor.getString(2));
                c.setUid(cursor.getString(3));
                c.setEmailId(cursor.getString(4));
                c.setContactNo(cursor.getString(5));
                c.setAddress(cursor.getString(7));
                c.setRank(cursor.getString(8));
                if(cursor.getString(9)!=null)
                {
                    c.setJobId1(Integer.parseInt(cursor.getString(9)));
                    c.setJobName1(cursor.getString(10));
                    c.setJobType1(cursor.getString(11));
                    c.setSalary1(Integer.parseInt(cursor.getString(12)));

                    if(cursor.getString(13)!=null)
                    {
                        c.setJobId2(Integer.parseInt(cursor.getString(13)));
                        c.setJobName2(cursor.getString(14));
                        c.setJobType2(cursor.getString(15));
                        c.setSalary2(Integer.parseInt(cursor.getString(16)));

                        if(cursor.getString(17)!=null)
                        {
                            c.setJobId3(Integer.parseInt(cursor.getString(17)));
                            c.setJobName3(cursor.getString(18));
                            c.setJobType3(cursor.getString(19));
                            c.setSalary3(Integer.parseInt(cursor.getString(20)));

                            if(cursor.getString(21)!=null)
                            {
                                c.setJobId4(Integer.parseInt(cursor.getString(21)));
                                c.setJobName4(cursor.getString(22));
                                c.setJobType4(cursor.getString(23));
                                c.setSalary4(Integer.parseInt(cursor.getString(24)));

                                companyList.add(c);
                            }
                            else
                            {
                                companyList.add(c);
                            }
                        }
                        else
                        {
                            companyList.add(c);
                        }
                    }
                    else
                    {
                        companyList.add(c);
                    }

                }
// Adding contact to list
                else
                {
                    companyList.add(c);
                }
                /*shopList.add(shop);*/
            } while (cursor.moveToNext());
        }
// return contact list
        return companyList;
    }



}
