    @Override
    public void onAddedPlaylist(Music music) {
        if (uriMediaSource != null) {
            addMediaSource(music);
        } else {
            Toast.makeText(HomeScreenActivity.this, "No Music in the queue. Can't add", Toast.LENGTH_SHORT).show();
        }
    }

