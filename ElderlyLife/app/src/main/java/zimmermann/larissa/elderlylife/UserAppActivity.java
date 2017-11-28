package zimmermann.larissa.elderlylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import zimmermann.larissa.elderlylife.Structure.Event;
import zimmermann.larissa.elderlylife.Structure.EventListResponse;
import zimmermann.larissa.elderlylife.adapter.EventAdapter;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.recycler.ClickListener;
import zimmermann.larissa.elderlylife.recycler.DividerItemDecoration;
import zimmermann.larissa.elderlylife.recycler.RecyclerTouchListener;
import zimmermann.larissa.elderlylife.utils.Utils;

public class UserAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppDataSingleton appData;

    //ReciclerView
    private RecyclerView recyclerView;
    private RecyclerTouchListener recyclerTouchListener;
    private DividerItemDecoration recyclerDecorator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_user_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewCardList);
        recyclerDecorator = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(recyclerDecorator);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        appData = AppDataSingleton.getInstace();
        if(appData.getUserType() == Utils.APP_USER) {
            navigationView.getMenu().clear(); //clear old inflated items.
            navigationView.inflateMenu(R.menu.activity_app_drawer); //inflate new items.
        }
        else if(appData.getUserType() == Utils.OWNER_USER) {
            navigationView.getMenu().clear(); //clear old inflated items.
            navigationView.inflateMenu(R.menu.activity_owner_drawer); //inflate new items.
        }


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
        getMenuInflater().inflate(R.menu.app, menu);
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

        if(appData.getUserType() == Utils.APP_USER) {
            if (id == R.id.nav_eventsNearMe) {

            } else if (id == R.id.nav_nextEvents) {

            } else if (id == R.id.nav_favoriteEvents) {

            } else if (id == R.id.nav_updateAccount) {

            } else if (id == R.id.nav_addAddress) {

            } else if (id == R.id.nav_logout) {

            }
        }
        else if(appData.getUserType() == Utils.OWNER_USER) {
            if (id == R.id.nav_addEvent) {
                // Handle the camera action
            } else if (id == R.id.nav_myEvent) {

            } else if (id == R.id.nav_updateAccount) {

            } else if (id == R.id.nav_logout) {

            }
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadPropsFromUrl(EventListResponse eventList) throws IOException {
        //verifica aqui se o corpo da resposta não é nulo
        if (eventList != null) {

            final List<Event> events = eventList.getEvents();

            recyclerView.removeOnItemTouchListener(recyclerTouchListener);

            //setPropTouchListener(events, recyclerView);

            recyclerView.addOnItemTouchListener(recyclerTouchListener);

            EventAdapter adapter = null;
            if(appData.getUserType() == Utils.APP_USER) {
                adapter = new EventAdapter(events, R.layout.event_component, getApplicationContext());
            }
            else if(appData.getUserType() == Utils.OWNER_USER) {
                adapter = new EventAdapter(events, R.layout.event_owner_component, getApplicationContext());
            }
            if(adapter != null) recyclerView.setAdapter(adapter);

        } else {
            Toast.makeText(getApplicationContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
        }
    }

    /*private void setPropTouchListener(final List<Event> events, final RecyclerView recyclerView){
        recyclerTouchListener = new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            //@Override
            public void onClick(View view, int position) {
                if(position < events.size()){
                    Proposicao prop = events.get(position);
                    Intent intent = new Intent(MainActivity.this, PropDetailsActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("Id", prop.getId()); //Your id
                    intent.putExtras(b); //Put your id to your next Intent
                    startActivity(intent);
                }
            }

            //@Override
            public void onLongClick(View view, int position) {

            }
        });
    }*/
}