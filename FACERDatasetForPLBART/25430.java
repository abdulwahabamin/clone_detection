    @Override
    public void onCompletion(MediaPlayer mp) {
        if (currentlyPlaying < filesQueue.size()) {
            currentlyPlaying++;
            playQueue();
        }
    }

