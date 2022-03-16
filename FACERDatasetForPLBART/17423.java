    @Override
    public synchronized boolean play(@NonNull MediaSessionCompat.QueueItem item) {
        Log.d(TAG, "play:called");
        Log.i(TAG, "play:item="+item);
        Log.i(TAG, "play:state="+Playback.states[mState]);

        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "play:player is preparing");
            return false;
        }

        // to play the player when configurePlayerState is called
        mPlayOnFocusGain = true;
        // try getting audio focus
        tryToGetAudioFocus();
        // register audio noisy receiver for headphone plug/unplug
        registerAudioNoisyReceiver();

        String mediaId = QueueHelper.getMediaIdOf(item);
        Log.i(TAG, "play:mediaId=" + mediaId);

        // check for mediaId
        if (mediaId == null) {
            Log.w(TAG, "play:mediaId is null");
            return false;
        }

        String musicId = MediaIdHelper.extractMusicIdFromMediaId(mediaId);
        Log.i(TAG, "play:musicId=" + musicId);

        // check for musicId
        if (musicId == null) {
            Log.w(TAG, "play:musicId is null");
            return false;
        }

        MediaMetadataCompat track = mMusicProvider.getMusic(musicId);

        // check for track in library
        if (track == null) {
            Log.w(TAG, "play:track not in library");
            return false;
        }

        // stop player if playing
        stopPlayer();
        // reset player for a new source
        resetPlayer();

        String source = track.getString(MusicProviderSource.CUSTOM_METADATA_KEY_TRACK_SOURCE);
        Log.i(TAG, "play:source=" + source);

        // set new data source
        if (setPlayerDataSource(source)) {
            Log.i(TAG, "play:set data resource successfully, go for preparing");
            // prepare player
            return preparePlayer();
        } else {
            Log.w(TAG, "play:cannot set data source");
            return false;
        }
    }

