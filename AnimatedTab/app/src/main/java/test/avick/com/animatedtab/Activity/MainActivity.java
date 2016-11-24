package test.avick.com.animatedtab.Activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

        RelativeLayout tab1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tab_icon_layout, null);
        ImageView imgTab1 = (ImageView) tab1.findViewById(R.id.img_tab);
        imgTab1.setBackground(getDrawable(android.R.drawable.ic_input_delete));
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams)imgTab1.getLayoutParams();
        params1.setMargins(300, 0, 150, 0); //substitute parameters for left, top, right, bottom
        imgTab1.setLayoutParams(params1);
        tabLayout.getTabAt(0).setCustomView(tab1);
        RelativeLayout tab2 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tab_icon_layout, null);
        ImageView imgTab2 = (ImageView) tab2.findViewById(R.id.img_tab);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams)imgTab2.getLayoutParams();
        params2.setMargins(150, 0, 150, 0); //substitute parameters for left, top, right, bottom
        imgTab2.setLayoutParams(params2);
        imgTab2.setBackground(getDrawable(android.R.drawable.ic_btn_speak_now));
        tabLayout.getTabAt(1).setCustomView(tab2);
        RelativeLayout tab3 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tab_icon_layout, null);
        ImageView imgTab3 = (ImageView) tab3.findViewById(R.id.img_tab);
        imgTab3.setBackground(getDrawable(android.R.drawable.ic_input_add));
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams)imgTab3.getLayoutParams();
        params3.setMargins(150, 0, 150, 0); //substitute parameters for left, top, right, bottom
        imgTab3.setLayoutParams(params3);
        tabLayout.getTabAt(2).setCustomView(tab3);
        RelativeLayout tab4 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tab_icon_layout, null);
        ImageView imgTab4 = (ImageView) tab4.findViewById(R.id.img_tab);
        imgTab4.setBackground(getDrawable(android.R.drawable.ic_menu_call));
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams)imgTab4.getLayoutParams();
        params4.setMargins(150, 0, 300, 0); //substitute parameters for left, top, right, bottom
        imgTab4.setLayoutParams(params4);
        tabLayout.getTabAt(3).setCustomView(tab4);



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


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView tabImage = (ImageView) tab.getCustomView().findViewById(R.id.img_tab);

                switch (tab.getPosition()){
                    case 0:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_input_delete));
                        break;
                    case 1:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_dialog_alert));
                        break;
                    case 2:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_menu_add));
                        break;
                    case 3:
                        tabImage.setBackground(getDrawable(android.R.drawable.stat_sys_speakerphone));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView tabImage = (ImageView) tab.getCustomView().findViewById(R.id.img_tab);

                switch (tab.getPosition()){
                    case 0:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_delete));
                        break;
                    case 1:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_btn_speak_now));
                        break;
                    case 2:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_input_add));
                        break;
                    case 3:
                        tabImage.setBackground(getDrawable(android.R.drawable.ic_menu_call));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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


    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
