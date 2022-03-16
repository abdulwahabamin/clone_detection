    private void makeNowPlayingView() {
        try {
            mTitle.setText(MusicUtils.sService.getTrackName());
            String artistName = MusicUtils.sService.getArtistName();
            if (MediaFile.UNKNOWN_STRING.equals(artistName)) {
                artistName = getString(R.string.unknown_artist_name);
            }
            mArtist.setText(artistName);
            mNowPlayingView.setOnFocusChangeListener(mFocuser);
            mNowPlayingView.setOnClickListener(this);
        } catch (RemoteException ex) {

        }
    }

