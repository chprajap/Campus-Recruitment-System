package com.example.chetan.campusrecruitmentsystem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelperAdmin extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "admincontacts.db";
    private static final String TABLE_NAME = "admincontacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_EMAIL = "emailId";
    private static final String COLUMN_CONTACTNO= "contactNo";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ADDRESS = "address";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL , "+COLUMN_NAME+" TEXT NOT NULL , "+COLUMN_UNAME+" TEXT NOT NULL , "+COLUMN_UID+" TEXT NOT NULL , "+COLUMN_EMAIL+" TEXT NOT NULL , "+COLUMN_CONTACTNO+" TEXT NOT NULL , "+COLUMN_PASSWORD+" TEXT NOT NULL , "+COLUMN_ADDRESS+" TEXT NOT NULL);";

    public DatabaseHelperAdmin(Context context)
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

    public void insertAdminContact(AdminContact c)
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
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
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
        /*list.add(cursor.getString(8));
        list.add(cursor.getString(9));
*/
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

    public void updateProfile(AdminContact c)
    {
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
     //   values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_UID,c.getUid());
        values.put(COLUMN_EMAIL,c.getEmailId());
        values.put(COLUMN_CONTACTNO,c.getContactNo());
        values.put(COLUMN_ADDRESS,c.getAddress());
        /*values.put("address",c.getAddress());
        values.put("ssc",c.getSsc());
        values.put("hsc",c.getHsc());*/

        db.update(TABLE_NAME,values,COLUMN_ID+" = ?",new String[]{
                String.valueOf(c.getId())
        });
    }

    public void changePassword(String password,String email,AdminContact c)
    {
        db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_UNAME,COLUMN_UID,COLUMN_EMAIL,COLUMN_CONTACTNO,COLUMN_PASSWORD,COLUMN_ADDRESS},COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);
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
