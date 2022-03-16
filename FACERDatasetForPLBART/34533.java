    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, fab, "aaaaa");
                    startActivityForResult(intent, SEARCH_CITY_CODE, options.toBundle());
                }
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        weatherService = MyApplication.getInstance().getWeatherService();
        if (isNetWorkAccess()) {
            if (!MyApplication.getInstance().isInitCities()) {
                //�?始化城市列表
                weatherService.initCities(WeatherConstant.CITY_SEARCH_TYPE_ALL_CHINA, new HeWeatherPickerImpl.InitCitiesCallback() {
                    @Override
                    public void initSuccess() {
                        MyApplication.getInstance().setInitCities(true);
                    }

                    @Override
                    public void initFailure() {
                        MyApplication.getInstance().setInitCities(false);
                    }
                });
            }
        } else {
            toast("无网络，2秒�?�自动退出");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 2000);
        }

        initView();
        initWeather();
    }

