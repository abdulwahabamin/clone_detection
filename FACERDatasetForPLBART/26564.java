    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        switch (Integer.parseInt(prefs.getString("theme", "3"))){
            case 1:
                Theme = R.style.GreenTheme;
                break;
            case 2:
                Theme = R.style.MyMaterialTheme;
                break;
            case 3:
                Theme = R.style.BlueTheme;
                break;
            case 4:
                Theme = R.style.BlueTheme;
                break;
        }
        setTheme(Theme);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();

        if(Intent.ACTION_SEARCH.equals(i.getAction())){
            String query = i.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this, SearchSugestionProvider.AUTHORITY, SearchSugestionProvider.MODE);
            suggestions.saveRecentQuery(query, null);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("location", query);
            editor.apply();
        } else {
            city = prefs.getString("location", "Berlin");
        }

        setupToolbar();
        /**
         * Helper classes
         */

        NotificationHelper = new NotificationHelper();
        WeatherHelper = new WeatherHelper();
        /**
         * Layouts
         */

        ErrorLayout = (LinearLayout) findViewById(R.id.error);
        sv = (ScrollView) findViewById(R.id.scroll_view);

        /**
         * Views
         */

        temp = (TextView)findViewById(R.id.t);
        loc = (TextView)findViewById(R.id.l);
        windspeed = (TextView)findViewById(R.id.windspeed);
        press = (TextView)findViewById(R.id.pressure);
        hum = (TextView)findViewById(R.id.humidity);
        desc = (TextView)findViewById(R.id.desc);
        errorcode = (TextView)findViewById(R.id.errorcode);
        todayStat = (ImageView) findViewById(R.id.stattoday);
        tomorrowStat = (ImageView) findViewById(R.id.tomorrowStat);
        tomorrow_desc = (TextView)findViewById(R.id.tomorrow_desc);
        tomorrow_temp = (TextView) findViewById(R.id.tomorrow_temp);
        currloc = (TextView) findViewById(R.id.current_location);
        card = (CardView) findViewById(R.id.card_view);
        card_tomorrow = (CardView) findViewById(R.id.card_tomorrow);
        /**
         * Removing ugly overscroll effect
         * Setting ScrollView's & ErrorLayout's visibility to gone
         */

        sv.setOverScrollMode(View.OVER_SCROLL_NEVER);
        sv.setVisibility(View.GONE);
        ErrorLayout.setVisibility(View.GONE);

        /**
         * Starting
         */

        getWeatherData(true);
        /**
         * [BETA] Starting, if activated, WeatherService to sync the weather data in Background
         * Current Status: Download fails
         * TODO fix problems
         */

        if(prefs.getBoolean("bgprocess", false)) {
            Intent intent = new Intent(this, WeatherService.class);
            PendingIntent PI = PendingIntent.getService(this, 0, intent, 0);
            AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            // schedule for every 30 seconds
            Calendar cal = Calendar.getInstance();
            alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30 * 60 * 1000, PI);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navigation_view);
        setupNavigationDrawer();

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setProgressViewOffset(true, 100, 150);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryLight);
        mSwipeRefreshLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = sv.getScrollY();
                if (scrollY == 0) mSwipeRefreshLayout.setEnabled(true);
                else mSwipeRefreshLayout.setEnabled(false);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getWeatherData(false);
                retried = false;
            }
        });
        SharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        if(!SharedPreferences.getBoolean("updatenews4", false)){
            showChangeLog();
        }

    }

