    private void initializeMusicServerPlaylist(PlayInfo playInfo) {
        if (playInfo != null) {
            Genre myGenre = getGenreByName(playInfo.genreName);
            if ((myGenre != null) && (myGenre.getPlaylist() != null)) {
                musicSrv.setList(myGenre.getPlaylist(), myGenre.getName());
                playingInfo.genreName = myGenre.getName();

                if (playInfo.trackId >= 0) {
                    playingInfo.trackId = playInfo.trackId;
                    musicSrv.setTrack(playingInfo.trackId);
                    if (playInfo.position > 0) {
                        playingInfo.position = playInfo.position;
                        musicSrv.seek(playingInfo.position);
                    }
                }
            }
        }
    }

