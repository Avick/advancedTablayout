package test.avick.com.animatedtab.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TableLayout;

/**
 * Created by avick on 11/23/16.
 */

public class CustomTabLayout extends TableLayout {

    private GestureDetector mGestureDetector;

    public CustomTabLayout(Context context) {
        super(context);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_:
////                // if we can scroll pass the event to the superclass
////                if (mScrollable) return super.onTouchEvent(ev);
////                // only continue to handle the touch event if scrolling enabled
////                return mScrollable; // mScrollable is always false at this point
//            default:
//                return super.onTouchEvent(ev);
//        }
    }




    public void setTabTextColors(int normalColor, int selectedColor) {

    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) >= Math.abs(distanceX);
        }
    }
}
