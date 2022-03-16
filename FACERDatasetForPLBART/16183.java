        public void registerSongListener(final SongListener listener) {
            if(songListenerList.size() == 0) {
                player.registerSeekListener(service);
            }
            if(!songListenerList.contains(listener)) {
                songListenerList.add(listener);
            }
        }

