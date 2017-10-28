package muzimuzi.jejuhackerton.com.muzimuzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import muzimuzi.jejuhackerton.com.muzimuzi.Adapter.MainViewPagerAdapter;
import muzimuzi.jejuhackerton.com.muzimuzi.View.CustomViewPager;
import muzimuzi.jejuhackerton.com.muzimuzi.util.Util;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CustomViewPager viewPager;
    RelativeLayout pointBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
        viewPager.setOffscreenPageLimit(5);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    ((ImageView)findViewById(R.id.toolbar_search)).setVisibility(View.VISIBLE);
                    ((ImageView)findViewById(R.id.toolbar_title)).setBackgroundDrawable(getResources().getDrawable(R.drawable.title_naturecoin));
                }
                else if(position == 1){

                    ((ImageView)findViewById(R.id.toolbar_search)).setVisibility(View.INVISIBLE);
                    ((ImageView)findViewById(R.id.toolbar_title)).setBackgroundDrawable(getResources().getDrawable(R.drawable.title_receive));
                }
                else if(position == 2){

                    ((ImageView)findViewById(R.id.toolbar_search)).setVisibility(View.INVISIBLE);
                    ((ImageView)findViewById(R.id.toolbar_title)).setBackgroundDrawable(getResources().getDrawable(R.drawable.title_scan));
                }
                else if(position == 3){

                    ((ImageView)findViewById(R.id.toolbar_search)).setVisibility(View.INVISIBLE);
                    ((ImageView)findViewById(R.id.toolbar_title)).setBackgroundDrawable(getResources().getDrawable(R.drawable.title_send));
                }
                else if(position == 4){

                    ((ImageView)findViewById(R.id.toolbar_search)).setVisibility(View.INVISIBLE);
                    ((ImageView)findViewById(R.id.toolbar_title)).setBackgroundDrawable(getResources().getDrawable(R.drawable.title_setting));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Util.myWalletAddress = Util.getMacAddress2Hash(getApplicationContext());

        pointBanner = (RelativeLayout) findViewById(R.id.point_banner);

    }

    @Override
    public void onClick(View view) {

    }
}
