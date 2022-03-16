    synchronized public Song prev() {
        if(currentPlaying>0)
            return queue.get(--currentPlaying);
        else {
            currentPlaying = queue.size() - 1;
            return queue.get(currentPlaying);
        }
    }

