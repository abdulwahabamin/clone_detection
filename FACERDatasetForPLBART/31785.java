    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((YourLocalWeather) getApplication()).applyTheme(this);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        setContentView(R.layout.activity_locations);

        setupActionBar();
        setupRecyclerView();
        locationsDbHelper = LocationsDbHelper.getInstance(this);
        addLocationButton = (FloatingActionButton) findViewById(R.id.add_location);
    }

