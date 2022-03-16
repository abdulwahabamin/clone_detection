    /**
     * Receiving song index from playlist view
     * and play the song
     */
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REQUEST_PLAYLIST) {
            currentSongIndex = data.getExtras().getInt(mSongIndex);
            // play selected song
            if (songsList == null) {
                Toast.makeText(getApplicationContext(), getString(R.string.songlist_null), Toast.LENGTH_SHORT).show();
            } else if (songsList.size() > 0) {
                playSong(currentSongIndex);
            }
        } else if (resultCode == REQUEST_ENABLE_BT) {
            if (songsList == null) {
                Toast.makeText(getApplicationContext(), getString(R.string.songlist_null), Toast.LENGTH_SHORT).show();
            } else if (songsList.size() > 0) {
                playSong(0);
            }
        }

    }

