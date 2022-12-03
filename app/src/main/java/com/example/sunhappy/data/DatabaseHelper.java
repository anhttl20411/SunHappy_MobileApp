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
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME_PRODUCT, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_PRODUCT + " ("+ COL_ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME_PRODUCT + " VARCHAR(50), " + COL_IMAGE_PRODUCT + " INTEGER, " + COL_PRICE_PRODUCT + " REAL," + COL_CATEGORY_PRODUCT + " VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);

        //String sql2 = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ("+ COL_ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(50), " + COL_PRICE + " REAL)";
        //sqLiteDatabase.execSQL(sql2);
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

    // kiểm tra table có dữ liệu chưa (nếu 0 là chưa, nếu lớn hơn 0 là có rồi, k chèn thêm dữ liệu mẫu nữa)
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

    public void createData(){
        if (numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam sọc vai trắng nâu đen', " + R.drawable.img_polo_1 + ", 180000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần kaki dài gấp chân', " + R.drawable.img_dai_1 + ", 250000, 'Quần dài')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần short kaki ống rộng có túi', " + R.drawable.img_short_1 + ", 150000, 'Quần short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Áo sơ mi nam tay dài cơ bản đủ size', " + R.drawable.img_somi_1 + ", 120000, 'Áo sơ mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Áo thun gấu trẻ trung', " + R.drawable.img_thun_1 + ", 70000, 'Áo thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo skater club gấu trẻ trung', " + R.drawable.img_polo_2 + ", 120000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần lưng chun dài bo cổ chân', " + R.drawable.img_dai_2 + ", 220000, 'Quần dài')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần short jean rách bụi bặm', " + R.drawable.img_short_2 + ", 190000, 'Quần short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Sơ mi nam tay ngắn form rộng', " + R.drawable.img_somi_2 + ", 110000, 'Áo sơ mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Áo thun nam họa tiết tay ngắn có sọc một bên', " + R.drawable.img_thun_2 + ", 60000, 'Áo thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam hai màu phối trắng', " + R.drawable.img_polo_3 + ", 130000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần ống rộng bo chân màu đen bụi bặm', " + R.drawable.img_dai_3 + ", 160000, 'Quần dài')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần đùi kaki cơ bản vải chất lượng', " + R.drawable.img_short_3 + ", 140000, 'Quần short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Sơ mi nam tay lửng form rộng đủ màu', " + R.drawable.img_somi_3 + ", 130000, 'Áo sơ mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Áo thun chất cotton TOM cực trend', " + R.drawable.img_thun_3 + ", 80000, 'Áo thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo trắng phối 2 đường sọc dài', " + R.drawable.img_polo_4 + ", 150000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần dài ống rộng chất cotton', " + R.drawable.img_dai_4 + ", 170000, 'Quần dài')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần short ôm chân chất kaki', " + R.drawable.img_short_4 + ", 140000, 'Quần short')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Sơ mi nam giả jean tay lửng', " + R.drawable.img_somi_4 + ", 90000, 'Áo sơ mi')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Áo thun F.WHITTLE tay ngắn đủ màu', " + R.drawable.img_thun_4 + ", 90000, 'Áo thun')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam chất siêu đẹp phối màu', " + R.drawable.img_polo_5 + ", 180000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần thun legging tập gym có dây rút', " + R.drawable.img_dai_5 + ", 150000, 'Quần dài')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần short vài dày dặn có túi', " + R.drawable.img_short_5 + ", 200000, 'Quần short')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo trơn đủ màu cơ bản thun lạnh', " + R.drawable.img_polo_6 + ", 170000, 'Áo polo')");
            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Quần đùi mặc ở nhà đầy đủ họa tiết', " + R.drawable.img_short_6 + ", 80000, 'Quần short')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam phối sọc giữa thun lạnh', " + R.drawable.img_polo_7 + ", 160000, 'Áo polo')");

            execSql("INSERT INTO " + TBL_NAME_PRODUCT + " VALUES(null, 'Polo nam phối sọc một bên', " + R.drawable.img_polo_8 + ", 160000, 'Áo polo')");
        }
    }

}
