    public void reset() {
        stopSeekMonitor();
        callSeekListeners();

        if(prepared) {
            mediaPlayer.release();
            mediaPlayer = null;
            prepared = false;
        }
    }

