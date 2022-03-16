    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        ArtistDTO currentArtist = extras.getParcelable(ARTIST_PARAM);
        if (currentArtist == null) {
            currentArtist = DTOConverter.getArtistDTO(MusicDataUtility.getArtistById(extras.getString(ARTIST_ID_PARAM), this));
        }

        TextView currentArtistTitle = (TextView) findViewById(R.id.current_artist_title);
        currentArtistTitle.setText(currentArtist.getArtistName());

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary));

        GridAutoFitLayoutManager gridLayoutManager = new GridAutoFitLayoutManager(this, 300);
        albumGrid = (RecyclerView) findViewById(R.id.album_grid);
        albumGrid.setLayoutManager(gridLayoutManager);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            if(currentArtist.getAlbums() != null && currentArtist.getAlbums().size() >0){
                albumGrid.setAdapter(new AlbumGridAdapter(currentArtist.getAlbums(), this));
                findViewById(R.id.no_albums_added).setVisibility(View.GONE);
            } else {
                findViewById(R.id.no_albums_added).setVisibility(View.VISIBLE);
            }
        }

        ViewUtils.drawerClickListener(this);
    }

