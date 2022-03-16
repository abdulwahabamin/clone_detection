    public void previous() {
        if (currentlyPlaying > 0 && filesQueue.size() > 0) {
            currentlyPlaying--;
            playQueue();
        }
    }

