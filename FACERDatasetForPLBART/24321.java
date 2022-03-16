    protected void interleaveAll(MenuItem item) {
        Intent intent = item.getIntent();
        int currentCount = intent.getIntExtra(CURRENT_COUNT, 0);
        int newCount = intent.getIntExtra(NEW_COUNT, 0);
        long[] songs = fetchSongList(mCurrentId);
        if (shuffleSongs()) MusicUtils.shuffleArray(songs);
        MusicUtils.interleave(getActivity(), songs, currentCount, newCount);
    }

