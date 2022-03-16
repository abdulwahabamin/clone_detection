    @SuppressWarnings("WeakerAccess")
    public boolean isSameBrowsingCategory(@NonNull String mediaId) {
        String[] newBrowseHierarchy = MediaIdHelper.getHierarchy(mediaId);
        MediaSessionCompat.QueueItem current = getCurrentMusic();
        if (current == null) {
            return false;
        }

        String curMediaId = current.getDescription().getMediaId();
        if (curMediaId == null) {
            Log.w(TAG, "updateMetadata:mediaid is null");
            return false;
        }

        String[] currentBrowseHierarchy = MediaIdHelper.getHierarchy(curMediaId);

        return Arrays.equals(newBrowseHierarchy, currentBrowseHierarchy);
    }

