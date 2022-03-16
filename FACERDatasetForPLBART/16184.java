        public void unregisterSongListener(SongListener listener) {
            songListenerList.remove(listener);
            if(songListenerList.size() == 0) {
                player.unregisterSeekListener(service);
            }
        }

