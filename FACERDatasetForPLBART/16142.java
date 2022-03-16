    synchronized public Song next() {
        if(currentPlaying< queue.size()-1)
            return queue.get(++currentPlaying);
        else {
            currentPlaying= 0;
            return queue.get(currentPlaying);
        }
    }

