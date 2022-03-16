    private void next() {
        if (!(songsList == null)) {
            try {
                if (songsList.size() > 0) {
                    try {
                        // check if next song is there or not
                        if (currentSongIndex < (songsList.size() - 1)) {
                            try {
                                playSong(currentSongIndex + 1);
                                currentSongIndex = currentSongIndex + 1;
                            } catch (Exception e) {
                            }
                        } else {
                            // play first song
                            playSong(0);
                            currentSongIndex = 0;
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
                // Toast.makeText(getApplicationContext(), getString(R.string.exception) + " [1] " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

