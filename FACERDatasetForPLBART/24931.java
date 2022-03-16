    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        sharedPreferences = getSharedPreferences("com.laithlab.rhythm", Context.MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary));
        loadingContainer = findViewById(R.id.loadingContainer);
        ProgressBar loadingProgess = (ProgressBar) findViewById(R.id.loadingProgess);
        loadingProgess.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        List<Artist> artists = MusicDataUtility.allArtists(getApplicationContext());
        browseGrid = (RecyclerView) findViewById(R.id.browse_grid);
        GridAutoFitLayoutManager gridLayoutManager = new GridAutoFitLayoutManager(this, 300);
        browseGrid.setLayoutManager(gridLayoutManager);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            if (artists != null && 0 < artists.size()) {
                artistGridAdapter = new ArtistGridAdapter(DTOConverter.getArtistList(artists), this);
                browseGrid.setAdapter(artistGridAdapter);
                findViewById(R.id.no_music_added).setVisibility(View.GONE);
            } else {
                findViewById(R.id.no_music_added).setVisibility(View.VISIBLE);
            }
        }
        ViewUtils.drawerClickListener(this);
    }

