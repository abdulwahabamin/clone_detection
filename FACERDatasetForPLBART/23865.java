        private int nextTrackIndex(int currentIndex) {
            int rslt = currentIndex + 1;
            switch (shuffle) {
                case PLAY_SEQUENTIAL:
                    if (rslt >= songs.size())
                        rslt = 0;
                    break;

                case PLAY_RANDOM_SONG:
                    logSuffleOrder("Songs", songOrder);
                    shuffleIndex++;
                    if (shuffleIndex >= songs.size())
                        shuffleIndex = 0;
                    rslt = songOrder[shuffleIndex];
                    break;

                case PLAY_RANDOM_ALBUM:
                    logSuffleOrder("albums", albumOrder);
                    long curentAlbum = songs.get(currentIndex).getAlbumId();
                    if (rslt >= songs.size()) {
                        rslt = 0;
                    }
                    long nextAlbum = songs.get(rslt).getAlbumId();

                    if (curentAlbum != nextAlbum) {
                        shuffleIndex++;
                        if (shuffleIndex >= albums.size())
                            shuffleIndex = 0;
                        int newAlbum = albumOrder[shuffleIndex];
                        rslt = albums.get(newAlbum).getTrack();
                    }
                    break;
            }
            return rslt;
        }

