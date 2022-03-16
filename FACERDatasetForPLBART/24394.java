    private void updateNowPlaying() {
        if (service != null && service.getAudioId() != -1) {
            nowPlaying.setVisibility(View.VISIBLE);

            titleView.setText(service.getTrackName());
            String artistName = service.getArtistName();
            if (MediaStore.UNKNOWN_STRING.equals(artistName)) {
                artistName = getString(R.string.unknown_artist_name);
            }
            artistView.setText(artistName);

            playPauseButton.setImageResource(service.isPlaying()
                    ? android.R.drawable.ic_media_pause
                    : android.R.drawable.ic_media_play);
        } else {
            nowPlaying.setVisibility(View.GONE);
        }

    }

