    @Override
    public void close() {
        handler.closeAllHandlers();
        if(mediaPlayer!=null && prepared) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

