        public void restoreSavedQueue() {
            final SharedPreferences sharedPreferences =
                    getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

            playQueue.changeTrack(sharedPreferences.getInt(LAST_SONG_INDEX, 0));
            try {
                player.prepareSong(playQueue.getCurrentPlaying());
                player.trueSeek(sharedPreferences.getInt(LAST_SEEK, 0));
                onSeekUpdated(player.getSeek());
            } catch (IOException e) {
                for (final SongListener listener : songListenerList) {
                    EasyHandler.executeOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onSongPlaybackFailed();
                        }
                    });
                }
            }
        }

