package com.hfad.bitsandpizzas;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActionBar;
import android.view.Menu;

public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_order,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
