package com.example.happybuy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    ListView listView;
    SearchAdapter adapter;
    String[] title;
    private SearchView search;
    private ImageView backArrow;
    ArrayList<SearchModel> arrayList = new ArrayList<SearchModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ActionBar actionBar = getSupportActionBar();

        WI


//        backArrow = findViewById(R.id.backArrowID);
        search = findViewById(R.id.searchID);
        listView = findViewById(R.id.listID);

        title = new String[]{"Computer", "Equipment", "Fashion", "Food", "HealthCare", "Sport"};

        for (int i = 0; i < title.length; i++) {
            SearchModel searchModel = new SearchModel(title[i]);
            arrayList.add(searchModel);
        }

        //pass results to searchViewAdapter

        adapter = new SearchAdapter(this, arrayList);

        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.searchID);
//        final SearchView searchView = (SearchView) menu.findItem(R.id.searchID).getActionView();
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else{
                    adapter.filter(newText);
                }

                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.searchID){
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
