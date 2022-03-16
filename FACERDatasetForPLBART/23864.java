        private int setShuffleToTrack(int currentIndex) {
            int rslt = 0;
            switch (shuffle) {
                case PLAY_RANDOM_SONG:
                    if (songOrder != null) {
                        rslt = Arrays.asList(songOrder).indexOf(currentIndex);
                    }
                    break;

                case PLAY_RANDOM_ALBUM:
                    if (currentIndex >= songs.size()) {
                        rslt = 0;
                    } else {
                        if (albumOrder != null) {
                            int currentAlbumIndex = -1;
                            Long currentAlbumId = songs.get(currentIndex).getAlbumId();
                            for (int i = 0; i < albums.size(); i++) {
                                if (currentAlbumId == albums.get(i).getID()) {
                                    currentAlbumIndex = i;
                                    break;
                                }
                            }

                            rslt = Arrays.asList(albumOrder).indexOf(currentAlbumIndex);
                            break;
                        }
                    }
            }
            if (rslt < 0)
                rslt = 0;
            return rslt;
        }

