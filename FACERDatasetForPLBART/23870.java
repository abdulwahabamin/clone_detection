    public synchronized void setShuffle(int playMode) {
        Log.d(TAG, "setShuffle(" + Integer.toString(playMode) + ") entry.");
        if (shuffle != playMode) {
            switch (playMode) {
                case PLAY_SEQUENTIAL:
                case PLAY_RANDOM_SONG:
                case PLAY_RANDOM_ALBUM:
                    // Generate new random track order
                    if (songs != null) {
                        songOrder = genPlayOrder(songs.size());
                    }

                    // Generate new random album order
                    if (albums != null)
                        albumOrder = genPlayOrder(albums.size());

                    // If we have a on-deck player, cancel it as our play order is
                    // changing.
                    if (currentTrackPlayer != null) {
                        currentTrackPlayer.setNextMediaPlayer(null);
                        if (onDeckTrackPlayer != null) {
                            onDeckTrackPlayer.release();
                            onDeckTrackPlayer = null;
                        }
                    }

                    // Set the new play mode and set the shuffle index to select
                    // the current track.
                    shuffle = playMode;
                    if (playingIndexInfo != null) {
                        playingIndexInfo.shuffleChanged();

                        // If we are playing something, then prepare the next track
                        // using the new play mode.
                        if (currentTrackPlayer != null) {
                            onDeckIndexInfo = new IndexInfo(playingIndexInfo);
                            currentTrackPlayer.setNextMediaPlayer(null);
                            onDeckTrackPlayer = prepareTrack(onDeckIndexInfo.getTrackIndex());
                        }
                    }
                    break;

                default:
                    Log.d(TAG, "setShuffle(" + Integer.toString(playMode) + ") Invalid value.");
            }
        }
    }

