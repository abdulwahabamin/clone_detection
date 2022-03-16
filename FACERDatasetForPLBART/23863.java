        public int getPrevShuffleIndex() {
            int rslt = trackIndex - 1;
            switch (shuffle) {
                case PLAY_SEQUENTIAL:
                    if (rslt < 0)
                        rslt = songs.size() - 1;
                    break;

                case PLAY_RANDOM_SONG:
                    shuffleIndex--;
                    if (shuffleIndex < 0)
                        shuffleIndex = songs.size() - 1;
                    rslt = songOrder[shuffleIndex];
                    break;

                case PLAY_RANDOM_ALBUM:
                    long curentAlbum = songs.get(trackIndex).getAlbumId();
                    if (rslt < 0) {
                        rslt = songs.size() - 1;
                    }
                    long nextAlbum = songs.get(rslt).getAlbumId();

                    if (curentAlbum != nextAlbum) {
                        shuffleIndex--;
                        if (shuffleIndex < 0)
                            shuffleIndex = albums.size() - 1;
                        int newAlbum = albumOrder[shuffleIndex];
                        rslt = albums.get(newAlbum).getLastTrackIndex();
                    }
                    break;
            }
            return rslt;
        }

