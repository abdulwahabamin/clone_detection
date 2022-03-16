    private Song getTrackInfo(int trackId) {
        Log.d(TAG, "getTrackInfo(" + trackId + ") Entry.");
        if ((currentDisplayPlayList != null) && !currentDisplayPlayList.isEmpty()) {
            if (trackId >= currentDisplayPlayList.size())
                trackId = 0;
            displayInfo.trackId = trackId;
            return currentDisplayPlayList.get(trackId);
        }
        return null;
    }

