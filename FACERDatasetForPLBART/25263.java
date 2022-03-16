    private void setPlayerListeners() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setScreenOnWhilePlaying(false);
        }
    }

