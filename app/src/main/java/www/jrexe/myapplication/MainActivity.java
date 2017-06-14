package www.jrexe.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager test_pager;
    private int[] drawables = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4, R.mipmap.image5};
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_pager = (ViewPager) findViewById(R.id.test_pager);
        for (int draw_id : drawables) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(draw_id);
            views.add(imageView);
        }
        test_pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //无限循环
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position % views.size()));
                return views.get(position % views.size());
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position % views.size()));
            }
        });
        //设置动画
        test_pager.setPageTransformer(true, new MyPageTransformer());
    }
}
