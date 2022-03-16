    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:called");

        setContentView(app.sonu.com.musicplayer.R.layout.activity_main);

        DaggerUiComponent.builder()
                .uiModule(new UiModule(this))
                .applicationComponent(((MyApplication)getApplicationContext())
                        .getApplicationComponent())
                .build()
                .inject(this);

        ButterKnife.bind(this);

        //setting toolbar as actionbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //setting hamburger icon for drawer
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_grey_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate:is presenter null="+(mPresenter==null));

        //setting up media browser tabs
        MediaBrowserPagerAdapter adapter = new MediaBrowserPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllSongsFragment(), AllSongsFragment.TAB_TITLE);
        adapter.addFragment(new AlbumsFragment(), AlbumsFragment.TAB_TITLE);
        adapter.addFragment(new ArtistsFragment(), ArtistsFragment.TAB_TITLE);
        adapter.addFragment(new PlaylistsFragment(), PlaylistsFragment.TAB_TITLE);
        mediaListVp.setAdapter(adapter);

        //making tabs work with viewpager
        tabLayout.setupWithViewPager(mediaListVp);

        lastAppBarBackgroundColor = AllSongsFragment.APP_BAR_BACKGROUND_COLOR;

        mediaListVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int newColor = AllSongsFragment.APP_BAR_BACKGROUND_COLOR;
                switch (position) {
                    case 0:
                        newColor = AllSongsFragment.APP_BAR_BACKGROUND_COLOR;
                        mainFab.hide();
                        break;
                    case 1:
                        newColor = AlbumsFragment.APP_BAR_BACKGROUND_COLOR;
                        mainFab.hide();
                        break;
                    case 2:
                        newColor = ArtistsFragment.APP_BAR_BACKGROUND_COLOR;
                        mainFab.hide();
                        break;
                    case 3:
                        newColor = PlaylistsFragment.APP_BAR_BACKGROUND_COLOR;
//                        mainFab.show();
                        break;
                }
                animateToolbarColors(lastAppBarBackgroundColor, newColor);
                lastAppBarBackgroundColor = newColor;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabReselected:"+mediaListVp.getCurrentItem()+" "+tab.getPosition());
                mPresenter.onTabClickOnSamePage(tab.getPosition());
            }
        });

        // setting up search ui
        if (searchResultsRv.getLayoutManager() == null) {
            searchResultsRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }

        searchQueryEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    searchClearIb.setVisibility(View.GONE);
                } else {
                    searchClearIb.setVisibility(View.VISIBLE);
                }

                mPresenter.onSearchQueryTextChange(s.toString());
            }
        });

        searchBackIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSearch();
            }
        });

        searchViewParentLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSearch();
            }
        });

        searchClearIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchQueryEt.setText("");
            }
        });

        // setting up navigationview ui
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuItemAbout:
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        drawerLayout.closeDrawers();
                        return false;
                }
                return false;
            }
        });

        mainFab.hide();

        mPresenter.onCreate(this);
    }

