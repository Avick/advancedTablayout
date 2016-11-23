package test.avick.com.animatedtab.Activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import test.avick.com.animatedtab.Adapter.DummyAdapter;
import test.avick.com.animatedtab.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    DummyAdapter mAdapter;
    GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.test_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.test_tabLayout);
        tabLayout.setTabTextColors(getResources().getColor(R.color.tab_normal_color), getResources().getColor(R.color.tab_selected_color));
        mAdapter = new DummyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

        gestureDetector = new GestureDetector(this, new YScrollDetector());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int colorId = getResources().getColor(R.color.greyish_brown);
                    switch (position){
                        case 0:
                            colorId = getResources().getColor(R.color.camel_color_dark);
                            break;
                        case 1:
                            colorId = getResources().getColor(R.color.red_ripple_color);
                            break;
                        case 2:
                            colorId = getResources().getColor(R.color.green_87_percent);
                            break;
                        case 3:
                            colorId = getResources().getColor(R.color.blue_dark_color);
                            break;
                    }
                    getWindow().setStatusBarColor(colorId);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return  true;//!gestureDetector.onTouchEvent(motionEvent);
            }
        });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) >= Math.abs(distanceX);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
