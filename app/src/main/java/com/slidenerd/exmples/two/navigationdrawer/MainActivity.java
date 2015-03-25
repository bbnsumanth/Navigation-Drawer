package com.slidenerd.exmples.two.navigationdrawer;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ViewPager pager = null;
    private ListView listView;
    private String[] categories;
    private int[] colors;
    private ActionBarDrawerToggle drawerListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView = (ListView) findViewById(R.id.drawer);
        categories = getResources().getStringArray(R.array.categories);
        colors = getResources().getIntArray(R.array.background);
        listView.setAdapter(new ArrayAdapter(this,R.layout.single_card,R.id.text,categories));
        listView.setOnItemClickListener(this);

        pager = (ViewPager) findViewById(R.id.pager);


        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            public  void onDrawerOpened(View drawerView){
                Toast.makeText(MainActivity.this,"drawer opened",Toast.LENGTH_SHORT).show();
            }
            public  void onDrawerClosed(View drawerView){
                Toast.makeText(MainActivity.this,"drawer closed",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void onStart(){
        super.onStart();

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        pager.setAdapter(new MyAdapter(manager));
    }

    public  void  onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if(drawerListener.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Hey "+categories[position]+" was clicked",Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    public void selectItem(int position) {
        listView.setItemChecked(position,true);
        setActionBarTitle(categories[position]);
    }

    public void setActionBarTitle(String category) {
        getActionBar().setTitle(category);
    }


    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment frag = null;

            if(i==0){
                frag = new FragmentA();

                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);

            }

            if(i==1){
                frag = new FragmentA();
                //frag.textView.setText("You can see "+categories[i]+" here.");
               // frag.rootLayout.setBackgroundColor(colors[i]);

            }
            if(i==2){
                frag = new FragmentB();
                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);
            }
            if(i==3){
                frag = new FragmentC();
                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);
            }
            if(i==4){
                frag = new FragmentA();
                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);
            }
            if(i==5){
                frag = new FragmentB();
                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);
            }
            if(i==6){
                frag = new FragmentC();
                //frag.textView.setText("You can see "+categories[i]+" here.");
                //frag.rootLayout.setBackgroundColor(colors[i]);
            }

            return frag;

        }

        @Override
        public int getCount() {
            return 7;
        }
        public CharSequence getPageTitle(int i){
            String title = new String();
            if(i==0){
                title = "World News";
            }
            if(i==1){
                title = "National News";
            }
            if(i==2){
                title = "Business News";
            }
            if(i==3){
                title = "Technology News";
            }
            if(i==4){
                title = "Sports News";
            }
            if(i==5){
                title = "Entertainment News";
            }
            if(i==6){
                title = "Science News";
            }
            return title;
        }
    }
}
