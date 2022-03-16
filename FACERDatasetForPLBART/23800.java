        PlayInfo(PlayInfo playInfo) {
            if (playInfo != null) {
                genreName = playInfo.genreName;
                trackId = playInfo.trackId;
                position = playInfo.position;
                shuffle = playInfo.shuffle;
                shuffleSeed = playInfo.shuffleSeed;
            } else {
                genreName = "";
                trackId = 0;
                position = 0;
                shuffle = MusicService.PLAY_SEQUENTIAL;
                shuffleSeed = 0;
            }
        }

