    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Bundle extras = getIntent().getExtras();
        musicContent = extras.getParcelable(MUSIC_CONTENT);
        if (musicContent != null) {
            actionModeCallback = new ActionModeCallback(musicContent.getContentType());
        }

        TextView albumTitle = (TextView) findViewById(R.id.txt_album);
        albumTitle.setText(musicContent.getPlaylistName());

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary));

        RecyclerView songList = (RecyclerView) findViewById(R.id.rv_songs_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        songList.setLayoutManager(layoutManager);

        songs = DTOConverter.getSongList(MusicDataUtility.getSongsFromList(musicContent, this));
        if (songs.size() > 0) {
            songListAdapter = new SongListAdapter(songs, this, musicContent.getContentType());
            songList.setAdapter(songListAdapter);
            findViewById(R.id.no_songs_added).setVisibility(View.GONE);
        }

        ViewUtils.drawerClickListener(this);
    }

