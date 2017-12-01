package zimmermann.larissa.elderlylife;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import zimmermann.larissa.elderlylife.adapter.SectionsStatePagerAdapter;
import zimmermann.larissa.elderlylife.fragment.AddressRegisterFragment;
import zimmermann.larissa.elderlylife.fragment.AppUserRegisterFragment;
import zimmermann.larissa.elderlylife.fragment.LoginFragment;
import zimmermann.larissa.elderlylife.fragment.RegisterFragment;
import zimmermann.larissa.elderlylife.fragment.UserTypeFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.containter);

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        //setup the pager
        setupViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "LoginFragment"); //0
        adapter.addFragment(new UserTypeFragment(), "UserTypeFragment"); //1
        adapter.addFragment(new RegisterFragment(), "RegisterFragment"); //2
        adapter.addFragment(new AppUserRegisterFragment(), "AppUserRegisterFragment"); //3
        adapter.addFragment(new AddressRegisterFragment(), "AddressRegisterFragment"); //4
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }
}
