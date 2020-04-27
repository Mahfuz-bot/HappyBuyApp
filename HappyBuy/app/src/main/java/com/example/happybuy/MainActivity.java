package com.example.happybuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.animations.DescriptionAnimation;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.TextSliderView;
import com.glide.slider.library.tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    List<RecycleModel> rModel;
    List<HomeMenu> mModel;
    private SliderLayout mDemoSlider;
    private Toolbar mToolbar;
    GridLayoutManager mGridLayoutManager;
   // private NestedScrollView mNestedScrollView;
    private ImageView logoImageView, searchText;
    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mNestedScrollView = findViewById(R.id.scrollHomeID);
        logoImageView = findViewById(R.id.imageViewLogo);

        logoImageView.setOnClickListener(this);

        searchText = findViewById(R.id.searchViewID);
        searchText.setOnClickListener(this);

        mToolbar = findViewById(R.id.myToolbar);
        //menu init
        mModel = new ArrayList<>();
        mModel.add(new HomeMenu("Computer", "Electronics", R.drawable.computer));
        mModel.add(new HomeMenu("Equipment", "Equipment", R.drawable.cogwheel));
        mModel.add(new HomeMenu("Fashion", "Fashion", R.drawable.hat));
        mModel.add(new HomeMenu("Food", "Food", R.drawable.restaurant));
        mModel.add(new HomeMenu("HealthCare", "HealthCare", R.drawable.medicines));
        mModel.add(new HomeMenu("Sport", "Sport", R.drawable.running));

        RecyclerView menuRecyclerView = findViewById(R.id.menuRecycleViewID);
        ViewCompat.setNestedScrollingEnabled(menuRecyclerView,false);
        MenuGridAdapter menuAdapter = new MenuGridAdapter(this,mModel);
        int mNoOfColumns = AutoGrid.calculateNoOfColumns(getApplicationContext());
        mGridLayoutManager = new GridLayoutManager(this, mNoOfColumns);
        menuRecyclerView.setLayoutManager(mGridLayoutManager);
//        menuRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        menuRecyclerView.setAdapter(menuAdapter);
        menuRecyclerView.setNestedScrollingEnabled(false);





        // trending init
        rModel = new ArrayList<>();
        rModel.add(new RecycleModel("Laptop",R.drawable.laptop));
        rModel.add(new RecycleModel("New laptop",R.drawable.see));
        rModel.add(new RecycleModel("Mac",R.drawable.mac));
        rModel.add(new RecycleModel("Laptop",R.drawable.laptop));
        rModel.add(new RecycleModel("New laptop",R.drawable.see));
        rModel.add(new RecycleModel("Mac",R.drawable.mac));
        rModel.add(new RecycleModel("Laptop",R.drawable.laptop));
        rModel.add(new RecycleModel("New laptop",R.drawable.see));
        rModel.add(new RecycleModel("Mac",R.drawable.mac));
        rModel.add(new RecycleModel("Laptop",R.drawable.laptop));
        rModel.add(new RecycleModel("New laptop",R.drawable.see));
        rModel.add(new RecycleModel("Mac",R.drawable.mac));

        RecyclerView recyclerView = findViewById(R.id.recycleViewID);
        ViewCompat.setNestedScrollingEnabled(recyclerView,false);
        RecycleAdapter mAdapter = new RecycleAdapter(this,rModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
//        setSupportActionBar(mToolbar);

        //onItemClickListener


        //slider code

        mDemoSlider = findViewById(R.id.slider);

        ArrayList<String> listUrl = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();

        listUrl.add("https://www.revive-adserver.com/media/GitHub.jpg");
        listName.add("JPG - Github");

        listUrl.add("https://tctechcrunch2011.files.wordpress.com/2017/02/android-studio-logo.png");
        listName.add("PNG - Android Studio");

        listUrl.add("http://static.tumblr.com/7650edd3fb8f7f2287d79a67b5fec211/3mg2skq/3bdn278j2/tumblr_static_idk_what.gif");
        listName.add("GIF - Disney");

        listUrl.add("http://www.gstatic.com/webp/gallery/1.webp");
        listName.add("WEBP - Mountain");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        //.diskCacheStrategy(DiskCacheStrategy.NONE)
        //.placeholder(R.drawable.placeholder)
        //.error(R.drawable.placeholder);

        for (int i = 0; i < listUrl.size(); i++) {
            TextSliderView sliderView = new TextSliderView(this);
            // if you want show image only / without description text use DefaultSliderView instead

            // initialize SliderLayout
            sliderView
                    .image(listUrl.get(i))
                    .description(listName.get(i))
                    .setRequestOption(requestOptions)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(this);

            //add your extra information
            sliderView.bundle(new Bundle());
            sliderView.getBundle().putString("extra", listName.get(i));
            mDemoSlider.addSlider(sliderView);
        }

        // set Slider Transition Animation
        // mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);

        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.stopCyclingWhenTouch(false);


    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
            backPressedTime = System.currentTimeMillis();


    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.imageViewLogo){
            finish();
            Intent logoIntent = new Intent(this,MainActivity.class);
            startActivity(logoIntent);

        }
        if(v.getId()==R.id.searchViewID){

            Intent searchIntent = new Intent(this,Search.class);
            startActivity(searchIntent);
//            onBackPressed();

        }



    }

//    @Override
//    protected void onStop() {
//        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
//        mDemoSlider.stopAutoCycle();
//        super.onStop();
//    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().getString("extra") + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

