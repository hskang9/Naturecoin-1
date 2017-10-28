package muzimuzi.jejuhackerton.com.muzimuzi;

import android.support.annotation.IdRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import muzimuzi.jejuhackerton.com.muzimuzi.Adapter.MainViewPagerAdapter;
import muzimuzi.jejuhackerton.com.muzimuzi.View.CustomViewPager;
import muzimuzi.jejuhackerton.com.muzimuzi.util.Util;


public class MainActivity extends AppCompatActivity {
    CustomViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    viewPager.setCurrentItem(0);
                }
                else if(tabId == R.id.tab_qrcode){
                    viewPager.setCurrentItem(1);

                }
                else if(tabId == R.id.tab_scan){
                    viewPager.setCurrentItem(2);

                }
                else if(tabId == R.id.tab_send){
                    viewPager.setCurrentItem(3);

                }
                else if(tabId == R.id.tab_setting){
                    viewPager.setCurrentItem(4);

                }
            }
        });
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), bottomBar.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

        Util.myWalletAddress = Util.getMacAddress2Hash(getApplicationContext());

    }

}
