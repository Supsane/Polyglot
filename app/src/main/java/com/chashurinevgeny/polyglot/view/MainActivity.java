package com.chashurinevgeny.polyglot.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chashurinevgeny.polyglot.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ListLessonsFragment.ListLessonListener, DetailsLessonFragment.DetailsLessonListener {

    private static final String IDLESSON = "idLesson";
    private static final String CALLINFLATEFRAGMENTS = "callInflateFragments";
    private int idLesson;
    private boolean isCallInflateFragments = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState != null) {
            isCallInflateFragments = savedInstanceState.getBoolean(CALLINFLATEFRAGMENTS);
        }

        if (savedInstanceState != null && isCallInflateFragments) {
            idLesson = savedInstanceState.getInt(IDLESSON);
            loadFragment();
            inflateFragmentsIfListLessonsItemClicked(idLesson);
        } else {
            loadFragment();
        }
    }

    private void loadFragment() {
        ListLessonsFragment listLessonsFragment = new ListLessonsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.listLessonsContainer, listLessonsFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void listLessonItemClicked(int id) {
        inflateFragmentsIfListLessonsItemClicked(id);
        idLesson = id;
    }

    private void inflateFragmentsIfListLessonsItemClicked(int id) {
        View listDetailsLessonContainer = findViewById(R.id.listDetailsLessonContainer);
        DetailsLessonFragment detailsLessonFragment = new DetailsLessonFragment();
        detailsLessonFragment.setIdLesson(id);
        if (listDetailsLessonContainer != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.listDetailsLessonContainer, detailsLessonFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.listLessonsContainer, detailsLessonFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
        isCallInflateFragments = true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(IDLESSON, idLesson);
        outState.putBoolean(CALLINFLATEFRAGMENTS, isCallInflateFragments);
    }

    @Override
    public void detailsLessonItemClicked(int id) {

    }

    @Override
    public void grammarReferenceItemClicked(int idLesson) {
        View listDetailsLessonContainer = findViewById(R.id.listDetailsLessonContainer);
        GrammarReferenceFragment grammarReferenceFragment = new GrammarReferenceFragment();
        if (listDetailsLessonContainer != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.listDetailsLessonContainer, grammarReferenceFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.listLessonsContainer, grammarReferenceFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
    }
}
