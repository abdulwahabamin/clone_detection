    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(LOGTAG, "onCreate - " + getIntent());

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        ActionBar actionBar = getActionBar();

        if (MusicUtils.android44OrLater() || !MusicUtils.hasMenuKey(this)
                || getResources().getBoolean(R.bool.tablet_layout)) {
            disableStackedActionBar(actionBar);
        }

        setContentView(R.layout.music_browser_activity);

        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the corresponding tab
                        ActionBar actionBar = getActionBar();
                        if (actionBar.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS) {
                            actionBar.setSelectedNavigationItem(position);
                        }
                    }
                });
        setupTabs(actionBar);

        mainView = findViewById(R.id.main);

        Button playQueueButton = (Button)findViewById(R.id.playqueue_button);
        if (playQueueButton != null) {
            playQueueButton.setOnClickListener(v -> startActivity(new Intent(this, MediaPlaybackActivity.class)));
        }

        if (savedInstanceState != null) {
            backStack = savedInstanceState.getParcelableArrayList("backStack");
        } else {
            backStack = new ArrayList<>(8);
        }

        parseIntent(getIntent(), true);

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        token = MusicUtils.bindToService(this, this, MobileMediaPlaybackService.class);
    }

