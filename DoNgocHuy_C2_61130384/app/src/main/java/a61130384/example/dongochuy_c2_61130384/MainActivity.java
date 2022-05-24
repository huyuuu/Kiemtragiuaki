package a61130384.example.dongochuy_c2_61130384;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase databaseTho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseTho = SQLiteDatabase.openOrCreateDatabase("/data/data/huy.tho/MyTho.db", null);
        NapVaoListView();
    }
    void NapVaoListView() {
        ListView listView = (ListView) findViewById(R.id.lvTho);

        ArrayList<String> dsSach = new ArrayList<String>();
        //----------------
        Cursor cs = databaseTho.rawQuery("SELECT * FROM THO",null);
        cs.moveToFirst();
        while (true)
        {
            if (cs.isAfterLast() == false) break;

            int ms = cs.getInt(0);
            String tentho = cs.getString(1);
            cs.moveToNext();
        }

        ArrayAdapter adapter = new ArrayAdapter( this,
                android.R.layout.simple_list_item_1,dsSach);
        listView.setAdapter(adapter);

    }


    //======================================
    void TaoBangVaThemDULieu(){
        // SQL xoa bang
        String sqlXoaBang = "DROP TABLE IF EXISTS";

        //Lenh tao bang
        String sqlTaoBang="CREATE TABLE BOOKS(BookID integer PRIMARY KEY," +
                " BookName text,\n" +
                "Page integer," +
                " Price Float," +
                " Description text)";
        databaseTho.execSQL(sqlTaoBang);

        String sqlThem1 = "INSERT INTO THOS VALUES(1, 'Java', 100, 9.99, 'Thơ về\n" + "java')";
        databaseTho.execSQL(sqlThem1);

        String sqlThem2 = "INSERT INTO THOS VALUES(2, 'Android', 320, 19.00, 'Android cơ\n" +
                "bản')";
        databaseTho.execSQL(sqlThem2);

        String sqlthem3 ="INSERT INTO BOOKS VALUES(3, 'Quê hương', 120, 0.99, 'thơ đọc\n" +
                "cho vui')";
        databaseTho.execSQL(sqlthem3);

        String sqlThem4 ="INSERT INTO THOS VALUES(4, 'Ngày Xưa', 1000, 29.50, 'Từ\n" +
                "điển 100.000 từ')";
        databaseTho.execSQL(sqlThem4);


    }



}