    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        collapsingToolbarLayout.setExpandedTitleMarginBottom(20);
        collapsingToolbarLayout.setExpandedTitleMargin(20,20,0,20);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedQuick);
        collapsingToolbarLayout.setExpandedTitleTypeface(AppController.getTypeface());

        // checking permissions
        storage=findViewById(R.id.storage);
        recents=findViewById(R.id.recents);
        storageDevices=findViewById(R.id.storageRV);
        storageDevices.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        fileEx=FileEx.newFileManager(Environment.getExternalStorageDirectory().toString(),this);
        quickAccess=findViewById(R.id.quick);
        quickAccess.setLayoutManager(new GridLayoutManager(this,2));
        recentFilesView=findViewById(R.id.recentList);
        recentListLayoutManager=new LinearLayoutManager(this);
        recentFilesView.setHasFixedSize(true);
        recentFilesView.setLayoutManager(recentListLayoutManager);
        recentsProgressBar=findViewById(R.id.progressBar);
        setRecentList();
        setTypeFace();
        mountStorage();
        setQuickAccessList();

    }

