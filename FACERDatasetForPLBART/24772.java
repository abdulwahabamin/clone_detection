    private void SetupRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        mFastScroller.setRecyclerView(mRecyclerView);
        mRecyclerView.setOnScrollListener(mFastScroller.getOnScrollListener());
        setRecyclerViewLayoutManager(mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MediaItem> mediaItems=PlayerConstants.SONGS_LIST;
        MainActivity.SetupRecyclerViewAdapter(getApplicationContext(), mediaItems);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                int Action=MainActivity.forSkipTrack;
                if (PlayerConstants.SONG_NUMBER==position)
                {
                    Action=MainActivity.forNothingKey;
                }
                if (RunServiceIfnot(SongPlayback.isPlayFromMainTrue,Action,position)){

                    if (PlayerConstants.SONG_NUMBER == position) {
                        changeListButton(position);
                        if (PlayerConstants.mSongPlayback.isPlay) {
                            PlayerConstants.mSongPlayback.pausePlayback();
                        }
                        else {
                            PlayerConstants.mSongPlayback.startPlayback();
                        }
                    } else {
                        setSongPlay(PlayerConstants.SONG_NUMBER, position);
                        PlayerConstants.SONG_NUMBER = position;
                        PlayerConstants.mSongPlayback.skipToTrack(PlayerConstants.SONG_NUMBER);
                    }
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

