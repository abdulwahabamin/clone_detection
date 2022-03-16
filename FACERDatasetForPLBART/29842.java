    public void initDrawer() {
        final IProfile profile = new ProfileDrawerItem().withName(getString(R.string.app_name))
                .withEmail("Version : " + BuildConfig.VERSION_NAME)
                .withIcon(R.mipmap.ic_launcher_x);
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withTextColor(ContextCompat.getColor(this , R.color.md_amber_400))
                .addProfiles(
                        profile
                )
                .withSelectionListEnabled(false)
                .withProfileImagesClickable(false)
                .build();
        SecondaryDrawerItem item1 = new SecondaryDrawerItem().withName(R.string.drawer_item_home)
                .withIcon(new IconicsDrawable(this)
                        .icon(WeatherIcons.Icon.wic_day_sunny))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        wf = new WeatherFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment, wf)
                                .commit();
                        return true;
                    }
                });
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName(R.string.drawer_item_graph)
                .withIcon(new IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_trending_up))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (!(f instanceof GraphsFragment)) {
                            GraphsFragment graphsFragment = newGraphInstance(new ArrayList<>(wf.getDailyJson()));
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment, graphsFragment)
                                    .commit();
                        }
                        return true;
                    }
                });
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withName(R.string.drawer_item_map)
                .withIcon(new IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_map))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (!(f instanceof MapsFragment)) {
                            MapsFragment mapsFragment = new MapsFragment();
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment, mapsFragment)
                                    .commit();
                        }
                        return true;
                    }
                });
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withName(R.string.drawer_item_add_city)
                .withIcon(new IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_add_location))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        showCityDialog();
                        return true;
                    }
                })
                .withSelectable(false);
        SecondaryDrawerItem item8 = new SecondaryDrawerItem().withName(R.string.drawer_item_about)
                .withIcon(new IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_info))
                .withSelectable(false)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        startActivity(new Intent(WeatherActivity.this, AboutActivity.class));
                        return true;
                    }
                });
        SecondaryDrawerItem item9 = new SecondaryDrawerItem().withName(R.string.settings)
                .withIcon(new IconicsDrawable(this)
                        .icon(GoogleMaterial.Icon.gmd_settings))
                .withSelectable(false)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        startActivity(new Intent(WeatherActivity.this, SettingsActivity.class));
                        return true;
                    }
                });
        DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        new DividerDrawerItem(),
                        item4
                )
                .addStickyDrawerItems(
                        item8,
                        item9);
        List<String> cities = dbHelper.getCities();
        final ListIterator<String> listIterator = cities.listIterator(cities.size());
        while (listIterator.hasPrevious()) {
            final String city = listIterator.previous();
            drawerBuilder.addDrawerItems(new SecondaryDrawerItem().withName(city)
                    .withIcon(new IconicsDrawable(this)
                            .icon(GoogleMaterial.Icon.gmd_place))
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            wf = new WeatherFragment().setCity(city);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment, wf)
                                    .commit();
                            return true;
                        }
                    })
            );
        }
        drawer = drawerBuilder.build();
    }

