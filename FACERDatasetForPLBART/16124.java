    public int getTrueSeek() {
        if(mediaPlayer != null && prepared) {
            return mediaPlayer.getCurrentPosition();
        } else {
            return 0;
        }
    }

