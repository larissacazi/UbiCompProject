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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zimmermann.larissa.elderlylife.Structure.Event;
import zimmermann.larissa.elderlylife.Structure.EventListResponse;
import zimmermann.larissa.elderlylife.adapter.EventAdapter;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.recycler.DividerItemDecoration;
import zimmermann.larissa.elderlylife.service.RetrofitService;
import zimmermann.larissa.elderlylife.service.ServiceGenerator;
import zimmermann.larissa.elderlylife.utils.Utils;

public class UserAppActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "UserAppActivity";

    //ReciclerView
    private RecyclerView recyclerView;
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
        recyclerView.setHasFixedSize(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Log.d(TAG, "UserType: " + AppDataSingleton.getInstace().getUserType());
        if(AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
            navigationView.getMenu().clear(); //clear old inflated items.
            navigationView.inflateMenu(R.menu.activity_app_drawer); //inflate new items.
        }
        else if(AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
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

        if(AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
            if (id == R.id.nav_eventsNearMe) {
                try {
                    loadEventList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (id == R.id.nav_nextEvents) {

            } else if (id == R.id.nav_favoriteEvents) {

            } else if (id == R.id.nav_updateAccount) {

            }  else if (id == R.id.nav_logout) {
                logout();
                finish();
            }
        }
        else if(AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
            if (id == R.id.nav_addEvent) {
                // Handle the camera action
            } else if (id == R.id.nav_myEvent) {

            } else if (id == R.id.nav_updateAccount) {

            } else if (id == R.id.nav_logout) {
                logout();
                finish();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        service.logout(AppDataSingleton.getInstace().getToken());

        AppDataSingleton.getInstace().clearInstace();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void loadEventList() throws IOException {
        String token = AppDataSingleton.getInstace().getToken();
        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        Call<EventListResponse> call = service.getAllEvents(token);

        call.enqueue(new Callback<EventListResponse>() {
            @Override
            public void onResponse(Call<EventListResponse> call, Response<EventListResponse> response) {

                if (response.isSuccessful()) {
                    EventListResponse respostaServidor = response.body();
                    //verifica aqui se o corpo da resposta não é nulo
                    if (respostaServidor != null) {

                        AppDataSingleton.getInstace().setEventListResponse(respostaServidor);

                        final List<Event> events = AppDataSingleton.getInstace().getEventListResponse().getEvents();

                        EventAdapter adapter = null;
                        if(AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
                            adapter = new EventAdapter(events, R.layout.event_component, getApplicationContext());
                        }
                        else if(AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
                            adapter = new EventAdapter(events, R.layout.event_owner_component, getApplicationContext());
                        }
                        if(adapter != null) recyclerView.setAdapter(adapter);

                    }else {

                        Toast.makeText(getApplicationContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getApplicationContext(), "Falha de comunicação", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EventListResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Falha!!!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, t.getMessage());
            }
        });

        Log.d(TAG, "PAssou...");
    }
}
