package com.sohan.verma.popupmenuviewwithimage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView menu_show;
    MenuBuilder menuBuilder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_show = (ImageView) findViewById(R.id.show_menu);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popmenu, menuBuilder);//this will show our menu list we add


        //Set item click listener
        menu_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(MainActivity.this,
                        menuBuilder,view);
                optionMenu.setForceShowIcon(true);

                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.menu_open_website:
                                Intent intent = new Intent(Intent.ACTION_VIEW,
                                        Uri.parse("https://www.instagram.com/sohan.12_"));
                                startActivity(intent);
                                return true;

                            case R.id.menu_open_toast:
                                Toast.makeText(MainActivity.this, "Show Toast", Toast.LENGTH_SHORT).show();
                                return true;

                            default:
                                return false;
                        }
                    }

                    @Override
                    public void onMenuModeChange(@NonNull MenuBuilder menu) {
                        //empty
                    }
                });

                optionMenu.show();
            }
        });

    }
}