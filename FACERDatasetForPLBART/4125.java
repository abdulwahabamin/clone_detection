    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Thread.setDefaultUncaughtExceptionHandler(new CatchCrash(this));
        ensureStartups(this);
        BriefSettings settings = State.getSettings();
        if(settings!=null && settings.getBoolean(BriefSettings.BOOL_STYLE_DARK)==Boolean.FALSE) {
            setTheme(R.style.AppThemeLight);
            //Log.e("THEME","Theme is LIGHT");
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        activity = this;

        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        State.loadState(savedInstanceState);

        Log.e("DEVICE", "SDK :" + android.os.Build.VERSION.SDK_INT);
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }


        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.icon);
        ab.setDisplayHomeAsUpEnabled(true);

        ActionBarManager.restart(this);

        checkSdCard();


        Device.hideKeyboard(this);

        Bgo.clearBackStack(activity);

        if (!BrowseService.isBrowseServiceRunning(activity)) {
            //Log.e("SERV", "Starting Browse service");
            Intent service = new Intent(activity, BrowseService.class);
            activity.startService(service);

        }
        BrowseService.setIsAppStarted(true);
    }

