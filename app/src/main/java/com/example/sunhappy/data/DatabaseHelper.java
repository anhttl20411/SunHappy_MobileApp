package com.example.sunhappy.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sunhappy.R;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME_PRODUCT = "product.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME_PRODUCT = "Product";
    public static final String COL_ID_PRODUCT = "ProductID";
    public static final String COL_NAME_PRODUCT = "ProductName";
    public static final String COL_IMAGE_PRODUCT = "ProductImage";
    public static final String COL_PRICE_PRODUCT = "ProductPrice";
    public static final String COL_CATEGORY_PRODUCT = "ProductCategory";
    //public static final String COL_FAVORITE_PRODUCT = "ProductFavorite";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME_PRODUCT, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_PRODUCT + " ("+ COL_ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME_PRODUCT + " VARCHAR(50), " + COL_IMAGE_PRODUCT + " INTEGER, " + COL_PRICE_PRODUCT + " REAL," + COL_CATEGORY_PRODUCT + " VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME_PRODUCT );
        onCreate(sqLiteDatabase);
    }

    //SELECT
    public Cursor getData(String sql){
        try {
            SQLiteDatabase db = getReadableDatabase();
            return db.rawQuery(sql, null);
        }
        catch (Exception e){
            return null;
        }
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sql);
        }
        catch (Exception e){
        }
    }

    // ki???m tra table c?? d??? li???u ch??a (n???u 0 l?? ch??a, n???u l???n h??n 0 l?? c?? r???i, k ch??n th??m d??? li???u m???u n???a)
    public int numbOfRows(){
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME_PRODUCT);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    //COL_ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    // COL_NAME_PRODUCT + " VARCHAR(50), " +
    // COL_IMAGE_PRODUCT + " INTEGER, " +
    // COL_PRICE_PRODUCT + " REAL," +
    // COL_CATEGORY_PRODUCT + " VARCHAR(50))
    // COL_FAVORITE_PRODUCT + " BOOLEAN)

    public void createData(){
        if (numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam s???c vai tr???ng n??u ??en', " + R.drawable.img_polo_1 + ", 180000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n kaki d??i g???p ch??n', " + R.drawable.img_dai_1 + ", 250000, 'Qu???n d??i')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n short kaki ???ng r???ng c?? t??i', " + R.drawable.img_short_1 + ", 150000, 'Qu???n short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, '??o s?? mi nam tay d??i c?? b???n ????? size', " + R.drawable.img_somi_1 + ", 120000, '??o s?? mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, '??o thun g???u tr??? trung', " + R.drawable.img_thun_1 + ", 70000, '??o thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo skater club g???u tr??? trung', " + R.drawable.img_polo_2 + ", 120000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n l??ng chun d??i bo c??? ch??n', " + R.drawable.img_dai_2 + ", 220000, 'Qu???n d??i')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n short jean r??ch b???i b???m', " + R.drawable.img_short_2 + ", 190000, 'Quan short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'S?? mi nam tay ng???n form r???ng', " + R.drawable.img_somi_2 + ", 110000, '??o s?? mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, '??o thun nam h???a ti???t tay ng???n s???c', " + R.drawable.img_thun_2 + ", 60000, '??o thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam hai m??u ph???i tr???ng', " + R.drawable.img_polo_3 + ", 130000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n ???ng r???ng bo ch??n m??u ??en', " + R.drawable.img_dai_3 + ", 160000, 'Qu???n d??i')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n ????i kaki c?? b???n v???i ch???t l?????ng', " + R.drawable.img_short_3 + ", 140000, 'Qu???n short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'S?? mi nam tay l???ng form r???ng ????? m??u', " + R.drawable.img_somi_3 + ", 130000, '??o s?? mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, '??o thun ch???t cotton TOM c???c trend', " + R.drawable.img_thun_3 + ", 80000, '??o thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo tr???ng ph???i 2 ???????ng s???c d??i', " + R.drawable.img_polo_4 + ", 150000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n d??i ???ng r???ng ch???t cotton', " + R.drawable.img_dai_4 + ", 170000, 'Qu???n d??i')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n short ??m ch??n ch???t kaki', " + R.drawable.img_short_4 + ", 140000, 'Qu???n short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'S?? mi nam gi??? jean tay l???ng', " + R.drawable.img_somi_4 + ", 90000, '??o s?? mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, '??o thun F.WHITTLE tay ng???n ????? m??u', " + R.drawable.img_thun_4 + ", 90000, '??o thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam ch???t si??u ?????p ph???i m??u', " + R.drawable.img_polo_5 + ", 180000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n thun legging t???p gym c?? d??y r??t', " + R.drawable.img_dai_5 + ", 150000, 'Qu???n d??i')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n short v??i d??y d???n c?? t??i', " + R.drawable.img_short_5 + ", 200000, 'Qu???n short')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo tr??n ????? m??u c?? b???n thun l???nh', " + R.drawable.img_polo_6 + ", 170000, '??o polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Qu???n ????i m???c ??? nh?? ?????y ????? h???a ti???t', " + R.drawable.img_short_6 + ", 80000, 'Qu???n short')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam ph???i s???c gi???a thun l???nh', " + R.drawable.img_polo_7 + ", 160000, '??o polo')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam ph???i s???c m???t b??n', " + R.drawable.img_polo_8 + ", 160000, '??o polo')");
        }
    }

}
