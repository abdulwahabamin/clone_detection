    /**
     * for getting queue index for a mediaid
     * @param mediaId mediaid of which index is required
     * @param queue list from which index is searched
     * @return index of the mediaid
     */
    public static int getQueueIndexOf(@NonNull String mediaId,
                                      @NonNull List<MediaSessionCompat.QueueItem> queue) {
        int index = 0;
        for (MediaSessionCompat.QueueItem item : queue) {
            if (mediaId.equals(item.getDescription().getMediaId())) {
                return index;
            }
            index++;
        }

        return -1;
    }

