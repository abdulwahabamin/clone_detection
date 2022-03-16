    private void initialSetup(Bundle savedInstanceState) {
        //Navigation Drawer setup
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        setupNavigationView();

        mHandler = new Handler();

        if (savedInstanceState == null) {
            navItemIndex = -1;
            CURRENT_TAG = TAG_DEFAULT;
            loadHomeFragment();
        }
    }

