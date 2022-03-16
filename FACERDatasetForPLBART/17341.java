    private boolean isQueueReusable(String mediaId) {
        if (mPlayingQueue == null) { //somehow queue is null
            return false;
        } else if (mPlayingQueue.size() == 0){ //queue has no songs
            return false;
        } else {
            return isSameBrowsingCategory(mediaId);
        }
    }

