package zimmermann.larissa.elderlylife;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import zimmermann.larissa.elderlylife.adapter.SectionsStatePagerAdapter;
import zimmermann.larissa.elderlylife.fragment.AddEventFragment;
import zimmermann.larissa.elderlylife.fragment.AddressAddEventFragment;

public class AddEventActivity extends AppCompatActivity {

    private static final String TAG = "AddEventActivity";

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Log.d(TAG, "onCreate: Started.");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.addEventContainer);

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
        adapter.addFragment(new AddEventFragment(), "AddEventFragment"); //0
        adapter.addFragment(new AddressAddEventFragment(), "AddressAddEventFragment"); //1
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }
}
