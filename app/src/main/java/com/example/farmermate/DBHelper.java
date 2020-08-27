package com.example.farmermate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "RiceInfo.sqlite";
    public static final String TABLE_NAME = "RiceRec";
    public static final String DBLOCATION = "/data/data/com.example.farmermate/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    RecomPage recomPage;

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        //onCreate(sqLiteDatabase);
        try {
            createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDatabase() throws IOException {
        boolean mDatabaseExist = checkDataBase();
        if(!mDatabaseExist)
        {
            this.getReadableDatabase();
            this.close();
            //Copy the database from assests
            copyDatabase();
            //Log.e(TAG, "createDatabase database created");
        }

    }

    private boolean checkDataBase()
    {
        File databasePath = new File(DBLOCATION + DBNAME);
        //File databasePath = mContext.getDatabasePath(DB_NAME);

        return databasePath.exists();
    }

    private boolean copyDatabase() {
        try {
            InputStream inputStream = mContext.getAssets().open(DBHelper.DBNAME);
            String outFileName = DBHelper.DBLOCATION + DBHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean openDatabase() {
        String mPath = DBLOCATION + DBNAME;
        //Log.v("mPath", mPath);
        mDatabase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDatabase != null;
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<Rice> getListRice() {
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM RiceRec", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }

    public List<Rice> getListRice2(){
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("Select * FROM RiceRec WHERE Solid_Cray = 1 AND Nope = 1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }


    public List<Rice> getListRice3() {
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM RiceRec", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }

    public List<Rice> getListRice4(){
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("Select * FROM RiceRec WHERE Solid_Cray = 1 AND Nope = 1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }

    public List<Rice> getListRice5() {
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM RiceRec", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }

    public List<Rice> getListRice6(){
        Rice rice = null;
        List<Rice> RiceList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("Select * FROM RiceRec WHERE Solid_Cray = 1 AND Nope = 1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rice = new Rice(cursor.getInt(0), cursor.getString(1), cursor.getString(9));
            RiceList.add(rice);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return RiceList;
    }





















}

