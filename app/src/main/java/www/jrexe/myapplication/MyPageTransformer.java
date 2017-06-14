package www.jrexe.myapplication;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            page.setScaleY(1f);
        } else if (position <= 1) {
            if (position < 0) {
                //左滑动
            } else if (position == 0) {
                page.setScaleY(1f);
                //右滑动
            } else {
                page.setScaleY(Math.max(1 - Math.abs(position), 0.5f));
                page.setScaleX(Math.max(1 - Math.abs(position), 0.5f));
            }
        } else {
            page.setScaleY(0f);
        }
    }
}