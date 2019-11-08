package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proteintracker.Adapter.DaftarTemanAdapter;
import com.example.proteintracker.Model.DaftarTeman;

import java.util.ArrayList;

public class DaftarTemanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaftarTemanAdapter daftarTemanAdapter;
    private ArrayList<DaftarTeman>DaftarTemanArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_teman);
        addData();

        recyclerView = findViewById(R.id.RvTeman);
        daftarTemanAdapter = new DaftarTemanAdapter(DaftarTemanArraylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarTemanActivity.this);
        recyclerView .setLayoutManager(layoutManager);
        recyclerView .setAdapter(daftarTemanAdapter);

       String contextManus[]={"Protein","Vitamin","Mineral"};
        ListView lv =  (ListView)findViewById(R.id.listViewMenu);
        ArrayAdapter<String>adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contextManus);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    private  void addData(){
        DaftarTemanArraylist =  new ArrayList<>();
        DaftarTemanArraylist.add(new DaftarTeman("Tita Marita Simangunsong","72170154","Baca Buku","Kaya Raya","Life is good","Perempuan",R.drawable.tita));
        DaftarTemanArraylist.add(new DaftarTeman("Yos Rafel Kristanto","72170092","Main game","Banyak uang","sans","Laki-Laki",R.drawable.yos));
        DaftarTemanArraylist.add(new DaftarTeman("Yashinta Novita Dewi","72170110","Tidur","Kaya raya","lebih baik naik gunung","Perempuan",R.drawable.yashinta));
        DaftarTemanArraylist.add(new DaftarTeman("Desta Siwi Prabawan","72170126","Main Musik","Kurus","gampanglah","Laki-laki",R.drawable.desta));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
                return true;
//            case R.id.item3:
//                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Silahkan memilih");
        menu.add(0, v.getId(), 0, "Simpan");
        menu.add(0, v.getId(), 0, "Tidak");
    }
}