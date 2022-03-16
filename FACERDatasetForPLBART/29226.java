    private void initWidgets(){
        imageSwitcher=(ImageSwitcher)findViewById(R.id.image_switcher);
        imageSwitcher.setFactory(this);
        AlphaAnimation inAnimation=new AlphaAnimation(0,1);
        inAnimation.setDuration(1000);
        AlphaAnimation outAnimation=new AlphaAnimation(1,0);
        inAnimation.setDuration(1000);
        imageSwitcher.setInAnimation(inAnimation);
        imageSwitcher.setOutAnimation(outAnimation);

        mDrawerWidget=(DrawerLayout)findViewById(R.id.drawer_widget);
        mDrawerWidget.setScrimColor(0x00ffffff);
        mDrawerView=findViewById(R.id.drawer_layout);
        mDrawerWidget.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                button_settings.setAlpha(1-slideOffset);
                mContentView.setTranslationX(mDrawerView.getWidth()*slideOffset);
            }
            @Override
            public void onDrawerOpened(View drawerView) {

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                button_settings.setAlpha(1);
                if(drawer_flag){
                    Intent intent=new Intent(MainActivity.this,CityManagementActivity.class);
                    startActivityForResult(intent,1);
                    drawer_flag=false;
                }
            }
            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        mContentView=findViewById(R.id.content_view);
        myViewPager=(MyViewPager)findViewById(R.id.my_viewpager);
        mTitleText=(TextView)findViewById(R.id.county_name);
        mTitleText.setText(wnl_spf.getString("selectedCountyName0",""));
        button_settings=(Button)findViewById(R.id.button_settings);
        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerWidget.openDrawer(GravityCompat.START);
            }
        });
        View manageCityView=mDrawerView.findViewById(R.id.managecityview_indrawerlayout);
        manageCityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_flag=true;
                mDrawerWidget.closeDrawer(GravityCompat.START);
            }
        });
        View exitActivityView=mDrawerView.findViewById(R.id.exitview_indrawerlayout);
        exitActivityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mfspa=new MyFragmentStatePagerAdapter(getSupportFragmentManager(),this);
        myViewPager.setAdapter(mfspa);
        myViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                String mCountyName = wnl_spf.getString("selectedCountyName" + position, "");
                mTitleText.setText(mCountyName);
                lastPageNum=nowPageNum;
                nowPageNum=position;
                View dotView=ll_dot_group.getChildAt(lastPageNum);
                dotView.setEnabled(false);
                dotView=ll_dot_group.getChildAt(position);
                dotView.setEnabled(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==ViewPager.SCROLL_STATE_IDLE&&nowPageNum!=lastPageNum){
                    imageSwitcher.setImageResource(backGroundRes[randomNum.nextInt(18)]);
                    if(nowPageNum==0||nowPageNum==mfspa.getCount()-1){
                        lastPageNum=nowPageNum;
                    }
                }
            }
        }
        );

        ll_dot_group=(LinearLayout)findViewById(R.id.ll_dot_group);
        initDotGroup();
        if(!wnl_spf.getString("selectedCountyCount", "0").equals("0")){
            ll_dot_group.getChildAt(0).setEnabled(true);
        }
    }

