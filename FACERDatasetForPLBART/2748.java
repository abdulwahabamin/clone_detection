    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings.init(getPreferences(Context.MODE_PRIVATE));
        settings.load();

        setContentView(R.layout.activity_main);

        Toolbar tBar = (Toolbar) findViewById(R.id.tBar);
        setSupportActionBar(tBar);

        // check if storage access permissions need to be requested
        getPermission();

        // notifications must be posted to a channel for Android O onwards
        createNotificationChannels();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        lView = (ListView) findViewById(R.id.lView);
        lView.setOnItemClickListener(this);
        lView.setOnItemLongClickListener(this);
        lView.setOnCreateContextMenuListener(this);

        // set current directory to external storage and list contents
        changeDir(Environment.getExternalStorageDirectory().getAbsolutePath());
        refresh();
    }

