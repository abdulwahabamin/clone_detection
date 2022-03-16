    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.general_toolbar);
        setSupportActionBar(toolbar);

        isDualPane = findViewById(R.id.weather_info_container) != null;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        workerFragment = (WorkerFragmentToRetrieveJsonString) fragmentManager
                .findFragmentByTag(WORKER_FRAGMENT_TAG);
        if (workerFragment == null) {
            workerFragment = new WorkerFragmentToRetrieveJsonString();
            fragmentTransaction.add(workerFragment, WORKER_FRAGMENT_TAG);
        }
        Fragment cityListFragment = fragmentManager.findFragmentByTag(LIST_FRAGMENT_TAG);
        if (cityListFragment == null) {
            cityListFragment = new CityListFragmentWithWeatherButtons();
            fragmentTransaction.add(R.id.city_list_container, cityListFragment,
                    LIST_FRAGMENT_TAG);
        }
        fragmentTransaction.commit();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);

        if (searchView != null) {
            handleIntent(getIntent());
        }
    }

