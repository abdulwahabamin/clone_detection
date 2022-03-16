    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

