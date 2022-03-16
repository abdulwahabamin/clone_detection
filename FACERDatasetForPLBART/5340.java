    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_access);
        setSupportActionBar(findViewById(R.id.toolbar));

        // creating ads
        MobileAds.initialize(this);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.UNIT_ID));
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                    Log.e(TAG,"failed to load ad...");
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.

               // onNewIntent(getIntent());
            }

        });
        interstitialAd.loadAd(new AdRequest.Builder().build());

        progressBar=findViewById(R.id.progress);

        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
        fileEx=FileEx.newFileManager(Environment.getExternalStorageDirectory().toString(),this);
        mediaRV=findViewById(R.id.mediaRV);
        onNewIntent(getIntent());
        sort=findViewById(R.id.sort);
        share=findViewById(R.id.share);
        delete=findViewById(R.id.delete);
        sort.setVisibility(View.GONE);


        gridLayoutManager=new GridLayoutManager(this,3);
        mediaRV.setLayoutManager(gridLayoutManager);
        mediaRV.setHasFixedSize(true);
        setFilterButtonListener();
        setOptionsButtonListener();
        setDeleteButtonListener();

        //handleIntent(getIntent());
    }

