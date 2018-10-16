package com.policonnect.team.policonnect20;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * @version 1
 * @author: PoliConnect Team
 */
public class MainActivity extends AppCompatActivity {
    private static long back_pressed;
    private ViewPager mViewPager;
    private final int mNumberOfFragment = 3;
    private Fragment[] fragments;
    private ImageButton[] menu;
    private Bitmap[] images;

    private static final String TAG = "MainActivity";

    //private TextView nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bar);

        mViewPager = new ViewPageFragment(this);
        mViewPager.setId(R.id.view_pager);

        final FrameLayout frameLayout = findViewById(R.id.main_fragment_placeholder);
        frameLayout.addView(mViewPager);

        FragmentManager fm = getSupportFragmentManager();
        setInitialFragment();

        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return mNumberOfFragment;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setChecked(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //nombreUsuario = (TextView)findViewById(R.id.nombreUsuario);
        //nombreUsuario.setText("Alejandro Arevalo");
    }

    private void setChecked(int position) {

        for (int i = 0; i < mNumberOfFragment; i++) {
            menu[i].setImageBitmap(images[i]);
        }
        menu[position].setImageBitmap(images[position + mNumberOfFragment]);
    }

    private void setInitialFragment() {
        if (fragments == null) {
            fragments = new Fragment[mNumberOfFragment];
            fragments[0] = new PantallaUsuario();
            fragments[1] = new PantallaBiblioteca();
            fragments[2] = new PantallaBienestar();
        }
        if (menu == null) {
            menu = new ImageButton[mNumberOfFragment];
            menu[0] = findViewById(R.id.userButton);
            menu[1] = findViewById(R.id.libraryButton);
            menu[2] = findViewById(R.id.welfareButton);
        }
        if (images == null) {
            images = new Bitmap[mNumberOfFragment * 2];
            images[0] = BitmapFactory.decodeResource(getResources(), R.drawable.user_ns);
            images[1] = BitmapFactory.decodeResource(getResources(), R.drawable.library_ns);
            images[2] = BitmapFactory.decodeResource(getResources(), R.drawable.welfare_ns);
            images[3] = BitmapFactory.decodeResource(getResources(), R.drawable.user_s);
            images[4] = BitmapFactory.decodeResource(getResources(), R.drawable.library_s);
            images[5] = BitmapFactory.decodeResource(getResources(), R.drawable.welfare_s);
        }

        menu[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
        menu[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });
        menu[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });


        mViewPager.setCurrentItem(0);
        setChecked(0);
    }


    /**
     * Este método asegura que el usuario salga de la aplicación cuando este oprima e botón "atrás" dos
     * veces con un lapso de tiempo de menos de 2 segundos.
     * Sobreescribe en metodo onBackPressed
     **/
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            System.exit(0);
        } else
            Toast.makeText(getBaseContext(), R.string.toast_backagain, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
