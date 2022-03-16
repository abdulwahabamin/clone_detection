    /** Returns true if queue is empty and playback can't continue. False otherwise */
    public boolean removeRemoteSongs(String userName) {
        for(int i=0;i<queue.size();) {
            Song song = queue.get(i);
            if(song.isRemote() && song.getLibraryUsername().equals(userName)) {
                queue.remove(i);
            } else {
                i++;
            }
        }

        return (queue.size() == 0);
    }

