package in.nishantarora.dummygram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;


public class DummyGram extends AppCompatActivity {

    private static final String TAG = "DummyGram Main";
    VerticalViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "Starting Up");
        setContentView(R.layout.activity_dummy_gram);
        viewPager = (VerticalViewPager) findViewById(R.id
                .viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    public void setNextItem () {
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {

        String[] dummyGramUrls = new String[]{
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.800.800/17437572_1874145329526506_4478198598076465152_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.87.895.895/17438501_261898844266731_4863590617751486464_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.800.800/17439090_132293403968177_1905755041675870208_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/17332731_245233095947249_8034602372963500032_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.800.800/17437910_1799324037061042_1238607549566025728_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/17333859_1857495114463221_2656988394189488128_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.799.799/17437510_1370543663004540_4129180540467150848_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.799.799/17332522_395478900824873_1087502980820762624_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.799.799/17267430_1880541752230103_3457171695134048256_n.jpg",
                "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/c0.100.799.799/17332650_731603887011754_8361458575419113472_n.jpg"
        };

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.v(TAG, String.valueOf(position));
            return DummyGramCardFragment.newInstance(dummyGramUrls[position]);
        }

        @Override
        public int getCount() {
            return dummyGramUrls.length;
        }
    }
}
