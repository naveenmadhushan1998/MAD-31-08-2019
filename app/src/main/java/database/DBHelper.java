package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userinfor.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTable = "CREATE TABLE "+ UserMaster.User.TABLE_NAME+" ("+
                UserMaster.User._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.User.COLUMN_NAME_USERNAME+ " TEXT,"+
                UserMaster.User.COLUMN_NAME_PASSWORD+ " TEXT);";

                db.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addUser(String userName,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(UserMaster.User.COLUMN_NAME_USERNAME,userName);
        values.put(UserMaster.User.COLUMN_NAME_PASSWORD,password);
        long result = db.insert(UserMaster.User.TABLE_NAME,null,values);

        if (result > 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    public List readAllInfor() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UserMaster.User._ID,
                UserMaster.User.COLUMN_NAME_USERNAME,
                UserMaster.User.COLUMN_NAME_PASSWORD
        };
        String sortOrder = UserMaster.User.COLUMN_NAME_USERNAME + " DESC";
        Cursor cursor = db.query(UserMaster.User.TABLE_NAME, projection,
                null,
                null,
                null,
                null,
                sortOrder);

        List usernameList = new ArrayList();
        List passwordList = new ArrayList();

        while (cursor.moveToNext()) {
            String username = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_PASSWORD));

            usernameList.add(username);
            passwordList.add(password);
int
        }
        return usernameList;
    }
    public int deleteUser (String name){
        SQLiteDatabase db =getReadableDatabase();
        String select = UserMaster.User.COLUMN_NAME_USERNAME+" Like ?";
        String [] selectionArgs = {name};

        String[] selectArgs = {name};
        int result = db.delete(UserMaster.User.TABLE_NAME,select,selectionArgs);

        if (result > 0){
            return 1;
            }
        else{
            return -1;
        }
    }
    public boolean updateUser (String username ,String pwd){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserMaster.User.COLUMN_NAME_PASSWORD,pwd);
        String select = UserMaster.User.COLUMN_NAME_USERNAME+" Like ?";
        String [] selectionargs = {username};
        int result = db.update(UserMaster.User.TABLE_NAME,values,select,selectionargs);

        if (result > 0)
            return true;
        else
            return false;
    }
}
//Continued

