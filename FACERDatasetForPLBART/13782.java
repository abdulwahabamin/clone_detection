    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        folder = (AppCompatTextView) findViewById(R.id.folder);
        selector = (AppCompatImageButton) findViewById(R.id.selector);
        setValues(SharedPrefUtils.getDownloadedFolder(this));
        selector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFolder();
            }
        });
        //fb banner ads
        adView = new AdView(this, getString(R.string.fb_banner_id), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

    }

