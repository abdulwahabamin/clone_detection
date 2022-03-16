    public void next() {
        if (currentlyPlaying < filesQueue.size()) {
            currentlyPlaying++;
            playQueue();
        }
    }

