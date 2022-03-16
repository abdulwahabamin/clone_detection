    public static String getMediaIdOf(long queueItemId,
                                      @NonNull List<MediaSessionCompat.QueueItem> queue) {
        for (MediaSessionCompat.QueueItem item : queue) {
            if (queueItemId == item.getQueueId()) {
                return item.getDescription().getMediaId();
            }
        }

        return null;
    }

