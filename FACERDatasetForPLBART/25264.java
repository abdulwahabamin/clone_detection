    private void removePlayerListeners() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(null);
            mediaPlayer.setOnInfoListener(null);
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.setScreenOnWhilePlaying(false);
            stopTimer();
        }
    }

