    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radius_search);
        overridePendingTransition(0, 0);


        dbHelper = PFASQLiteHelper.getInstance(this);
        initialize();
    }

