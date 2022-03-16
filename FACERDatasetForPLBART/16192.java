        public void removeRemoteUserSongs(String userName) {
            if(playQueue != null) {
                boolean empty = playQueue.removeRemoteSongs(userName);
                if(empty) {
                    player.reset();
                    for(SongListener listener : songListenerList) {
                        listener.onPlayQueueDestroyed();
                    }
                    playQueue = null;
                    endService(true);
                }
            }
        }

