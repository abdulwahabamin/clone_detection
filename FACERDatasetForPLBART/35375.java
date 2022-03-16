    @Override
    public void initView() {
        toolbar.setTitle("�?都");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键�?�用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setItemTextColor(null);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, 0, 0);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);
    }

