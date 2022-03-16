    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bgView = (ImageView) findViewById(R.id.bgView);
//        ImageHelper.loadBlurBg(this, bgView);

        if (getIntent().getExtras() == null) {
            FireLog.e(TAG, "Extras are null");
            finish();
        }
        mediaItemWrapper = getIntent().getExtras().getParcelable(EXTRA_MEDIA_ITEM_WRAPPER);
        if (mediaItemWrapper == null) {
            FireLog.e(TAG, "mediaItemWrapper is null");
            finish();
        }
        String title = mediaItemWrapper.getMediaItem().getDescription().getTitle() + "";
        Fragment fragment = MediaListFragment.newInstance(title, mediaItemWrapper.getMediaItem().getMediaId());
        String tag = MediaListFragment.TAG;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContent, fragment, tag)
                .commit();
    }

