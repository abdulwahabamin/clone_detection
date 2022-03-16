    private void updateNowPlaying() {
        if (service != null && service.getAudioId() != -1) {
            titleView.setText(service.getTrackName());
            String artistName = service.getArtistName();
            if (MediaStore.UNKNOWN_STRING.equals(artistName)) {
                artistName = getString(R.string.unknown_artist_name);
            }
            artistView.setText(artistName);

            playPauseButton.setImageResource(service.isPlaying()
                    ? android.support.v17.leanback.R.drawable.lb_ic_pause
                    : android.support.v17.leanback.R.drawable.lb_ic_play);
        }
    }

