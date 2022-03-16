    /**
     * Update what's playing
     */
    private void updateMusicInfo() {
        if (MusicUtils.mService == null) {
            return;
        }

        String artistName = MusicUtils.getArtistName();
        String albumName = MusicUtils.getAlbumName();
        String trackName = MusicUtils.getTrackName();
        String albumId = String.valueOf(MusicUtils.getCurrentAlbumId());
        mTrackName.setText(trackName);
        mAlbumArtistName.setText(albumName + " - " + artistName);
        mDuration = MusicUtils.getDuration();
        mTotalTime.setText(MusicUtils.makeTimeString(getActivity(), mDuration / 1000));

        ImageInfo mInfo = new ImageInfo();
        mInfo.type = TYPE_ALBUM;
        mInfo.size = SIZE_THUMB;
        mInfo.source = SRC_FIRST_AVAILABLE;
        mInfo.data = new String[]{ albumId , artistName, albumName };
        
        ImageProvider.getInstance( getActivity() ).loadImage( mAlbumArt, mInfo );

        // Theme chooser
        ThemeUtils.setTextColor(getActivity(), mTrackName, "audio_player_text_color");
        ThemeUtils.setTextColor(getActivity(), mAlbumArtistName, "audio_player_text_color");
        ThemeUtils.setTextColor(getActivity(), mTotalTime, "audio_player_text_color");

    }

