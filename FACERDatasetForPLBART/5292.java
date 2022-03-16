    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.singh.multimeet.quicxplo.R.layout.activity_browse);
        contentList = findViewById(com.singh.multimeet.quicxplo.R.id.contentList);
        sharedPreferences = getSharedPreferences(Util.DIR_DATA, Context.MODE_PRIVATE);

        // creating ads
        MobileAds.initialize(this);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(com.singh.multimeet.quicxplo.R.string.UNIT_ID));

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e(TAG, "failed to load ad...");
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.

                // onNewIntent(getIntent());
            }

        });
        // checking External uri permissions.
        toolbar = findViewById(com.singh.multimeet.quicxplo.R.id.toolbar);
        setSupportActionBar(toolbar);
        root = findViewById(com.singh.multimeet.quicxplo.R.id.root);
        crumbs = findViewById(com.singh.multimeet.quicxplo.R.id.crumbs);
        crumbs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        scrollView = findViewById(com.singh.multimeet.quicxplo.R.id.scroll);


        // Floating option buttons
        copy = findViewById(com.singh.multimeet.quicxplo.R.id.copy);
        cut = findViewById(com.singh.multimeet.quicxplo.R.id.move);
        rename = findViewById(com.singh.multimeet.quicxplo.R.id.rename);
        details = findViewById(com.singh.multimeet.quicxplo.R.id.details);
        paste = findViewById(com.singh.multimeet.quicxplo.R.id.paste);
        delete = findViewById(com.singh.multimeet.quicxplo.R.id.delete);
        create = findViewById(com.singh.multimeet.quicxplo.R.id.create);
        options = findViewById(com.singh.multimeet.quicxplo.R.id.options);
        share = findViewById(com.singh.multimeet.quicxplo.R.id.share);

        // Tooltips
        copy_t = findViewById(com.singh.multimeet.quicxplo.R.id.copy_t);
        cut_t = findViewById(com.singh.multimeet.quicxplo.R.id.move_t);
        rename_t = findViewById(com.singh.multimeet.quicxplo.R.id.rename_t);
        details_t = findViewById(com.singh.multimeet.quicxplo.R.id.details_t);
        delete_t = findViewById(com.singh.multimeet.quicxplo.R.id.delete_t);
        create_t = findViewById(com.singh.multimeet.quicxplo.R.id.create_t);
        share_t = findViewById(com.singh.multimeet.quicxplo.R.id.share_t);

        // creating options menu
        options.setOnClickListener((view -> {
            boolean toggle=(isMovable||isCopied);
           if(toggle){
               options.setImageResource(com.singh.multimeet.quicxplo.R.drawable.options);
               filesAdapter.clearSelectedList();
               filesAdapter.disableSelection();
               paste.setVisibility(View.GONE);
               showOrHideOptions(View.GONE);
               isCopied=false;
               isMovable=false;
           }

           else if (scrollView.getVisibility() == View.GONE) {
                showOrHideOptions(View.VISIBLE);

            } else {
                showOrHideOptions(View.GONE);
            }
        }));

        // set listeners for all option buttons.
        setCreateButtonListener();
        setRenameButtonListener();
        setDeleteButtonListener();
        setCutButtonListener();
        setCopyButtonListener();
        setPasteButtonListener();
        setShareButtonListener();
        setDetailButtonListener();


        contentList.setLayoutManager(new LinearLayoutManager(this));

        if (getIntent() != null) {
            dir = getIntent().getStringExtra(getResources().getString(com.singh.multimeet.quicxplo.R.string.dir_reference));
        }

        if (isExternalAvailable() && dir != null) {
            fileEx = FileEx.newFileManager(dir, this);
            if (sharedPreferences.getString(Util.BASE_URI, "").equals("")
                    && !dir.contains("emulated"))
                startActivityForResult(new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE), EXTERNAL);
            fileEx.setCurrentDir(dir);
            breadCrumbsAdapter = new BreadCrumbsAdapter(fileEx.getCurrentDir(), crumbs);
            breadCrumbsAdapter.setBreadCrumbsListener(this);
            crumbs.setAdapter(breadCrumbsAdapter);
            crumbs.smoothScrollToPosition(fileEx.getCurrentDir().length() - 1);
            loadDirectories();
        }

        setTypeFace();
        setOrRefreshAdapter();
        mountStorage();
        createEmptyMessage();
    }

