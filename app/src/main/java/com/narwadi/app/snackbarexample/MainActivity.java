package com.narwadi.app.snackbarexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void SnackbarSimple(View v) {
        Snackbar snackbar;
        snackbar = Snackbar.make(coordinatorLayout, "Selamat Datang di Snackbar Example", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void SnackbarAction(View v) {
        Snackbar snackbar;
        snackbar = Snackbar.make(coordinatorLayout, "Pesan Telah Dihapus", Snackbar.LENGTH_LONG)
                .setAction("BATAL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1;
                        snackbar1 = Snackbar.make(coordinatorLayout, "Pesan Telah Dikembalikan", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }

    public void SnackbarCustom(View v) {
        Snackbar snackbar;
        snackbar = Snackbar.make(coordinatorLayout, "No Internet Connection", Snackbar.LENGTH_LONG)
                .setAction("COBA LAGI", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1;
                        snackbar1 = Snackbar.make(v, "Connect To Internet", Snackbar.LENGTH_SHORT);

                        View sb1View = snackbar1.getView();
                        TextView sb1TextView = (TextView) sb1View.findViewById(android.support.design.R.id.snackbar_text);
                        sb1TextView.setTextColor(Color.CYAN);

                        snackbar1.show();
                    }
                });
        // Changing message text color
        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView sbTextView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        sbTextView.setTextColor(Color.MAGENTA);

        snackbar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
