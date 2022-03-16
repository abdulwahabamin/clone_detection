    /**
     * Function to play a song
     *
     * @param songIndex - index of song
     */
    public void playSong(int songIndex) {
        if (!(songsList == null)) {
            try {
                if (songsList.size() > 0) {
                    try {
                        mp.reset();
                        mp.setDataSource(songsList.get(songIndex).get(mSongPath));
                        mp.prepare();
                        mp.start();
                    } catch (Exception e) {
                    }

                    try {
                        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                        mmr.setDataSource(songsList.get(songIndex).get(mSongPath));
                        String songArtist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                        String songTitle = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                        songArtistLabel.setText(songArtist);
                        songTitleLabel.setText(songTitle);

                        try {
                            byte[] data = mmr.getEmbeddedPicture();
                            imageView.setImageBitmap(BitmapFactory.decodeByteArray(data, 0, data.length));
                        } catch (Exception e) {
                        }
                    } catch (Exception e) {
                        String songTitle = songsList.get(songIndex).get(mSongTitle);
                        songTitleLabel.setText(songTitle);
                    }

                    try {
                        // Changing Button Image to pause image
                        btnPlay.setImageResource(android.R.drawable.ic_media_pause);
                    } catch (Exception e) {
                    }

                    try {
                        // set Progress bar values
                        songProgressBar.setProgress(0);
                        songProgressBar.setMax(100);

                        // Updating progress bar
                        updateProgressBar();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
                // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

