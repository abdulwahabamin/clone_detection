    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Activity", WeatherActivity.class.getSimpleName());
        mManager = NotificationManagerCompat.from(this);
        preferences = new Prefs(this);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideFab();
                showInputDialog();
            }
        });
        Intent intent = getIntent();
        handler = new Handler();
        fab.show();
        wf = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", intent.getIntExtra(Constants.MODE, 0));
        wf.setArguments(bundle);
        gf = new GraphsFragment();
        //mf = new MapsFragment();
        dbHelper = new DBHelper(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, wf)
                .commit();
        initDrawer();
        NotificationService.enqueueWork(this, new Intent(this, WeatherActivity.class));
    }

