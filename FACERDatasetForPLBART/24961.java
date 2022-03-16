    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_grid);

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
        noPlaylists = findViewById(R.id.no_playlists_added);

        List<Playlist> playlists = MusicDataUtility.getPlayists(this);
        playlistGridAdapter = new PlaylistGridAdapter(playlists, this);
        RecyclerView playlistGridView = (RecyclerView) findViewById(R.id.playist_grid);
        GridAutoFitLayoutManager gridLayoutManager = new GridAutoFitLayoutManager(this, 300);
        playlistGridView.setLayoutManager(gridLayoutManager);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            playlistGridView.setAdapter(playlistGridAdapter);
            if (playlists.size() > 0){
                noPlaylists.setVisibility(View.GONE);
            } else {
                noPlaylists.setVisibility(View.VISIBLE);
            }
        }

        FloatingActionButton addPlaylist = (FloatingActionButton) findViewById(R.id.add_playlist);
        addPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper.showAddPlaylistDialog(PlaylistGridActivity.this);
            }
        });

        ViewUtils.drawerClickListener(this);
    }

