    public int getSeek() {
        if(prepared) {
            return mediaPlayer.getCurrentPosition() * MAX_SEEK_VALUE / mediaPlayer.getDuration();
        } else {
            return 0;
        }
    }

