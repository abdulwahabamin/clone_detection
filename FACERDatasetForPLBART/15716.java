    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        ItemListActivity.mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Playlists(name VARCHAR);");
        ItemListActivity.mydatabase.execSQL("CREATE TABLE IF NOT EXISTS PlaylistSongs(name VARCHAR, song VARCHAR);");

        recyclerView = (RecyclerView) findViewById(R.id.playlist_recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(new ArrayList<>(playlistNames));
        if (playlistNames.size() == 0) {
            Cursor resultSet = ItemListActivity.mydatabase.rawQuery("Select * from Playlists", null);
            if (resultSet.getCount() > 0) {
                resultSet.moveToFirst();
                String nameFromDB = resultSet.getString(0);
                playlistNames.add(nameFromDB);
                while (!resultSet.isLast()) {
                    resultSet.moveToNext();
                    nameFromDB = resultSet.getString(0);
                    playlistNames.add(nameFromDB);
                }
            }
            resultSet.close();
            resultSet = ItemListActivity.mydatabase.rawQuery("Select * from PlaylistSongs", null);
            resultSet.moveToFirst();
            if (resultSet.getCount() > 0) {
                resultSet.moveToFirst();
                String playlistNameFromDB = resultSet.getString(0);
                String songNameFromDB = resultSet.getString(1);
                if (playlists.get(playlistNameFromDB) == null) {
                    playlists.put(playlistNameFromDB, new ArrayList<>(Arrays.asList(songNameFromDB)));
                } else {
                    playlists.get(playlistNameFromDB).add(songNameFromDB);
                }
                playlists.put(playlistNameFromDB, new ArrayList<String>());
                while (!resultSet.isLast()) {
                    resultSet.moveToNext();
                    playlistNameFromDB = resultSet.getString(0);
                    songNameFromDB = resultSet.getString(1);
                    if (playlists.get(playlistNameFromDB) == null) {
                        playlists.put(playlistNameFromDB, new ArrayList<>(Arrays.asList(songNameFromDB)));
                    } else {
                        playlists.get(playlistNameFromDB).add(songNameFromDB);
                    }
                }
                resultSet.close();
            }
        }

        for (String playlistName : playlistNames) {
            if (playlists.get(playlistName) == null) {
                playlists.put(playlistName, new ArrayList<String>());
            }
        }
        recyclerView.setAdapter(mAdapter);


        final EditText playlistInput = findViewById(R.id.playlist_text);
        playlistInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                playlistInputValue = s.toString();
            }
        });

        final Button button = findViewById(R.id.playlist_add_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playlistNames.add(playlistInputValue);
                playlists.put(playlistInputValue, new ArrayList<String>());
                mAdapter.notifyDataSetChanged();
                ItemListActivity.mydatabase.execSQL("INSERT INTO Playlists VALUES('" + playlistInputValue + "');");
                playlistInput.setText("");
            }
        });

        final TextView addSongText = findViewById(R.id.add_song_text);

        if (songToAddId.length() > 0) {
            button.setVisibility(View.GONE);
            playlistInput.setVisibility(View.GONE);
            addSongText.setText("Pick a playlist for: \n" + SongContent.ITEM_MAP.get(songToAddId).name);
        } else {
            addSongText.setVisibility(View.GONE);
        }

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

