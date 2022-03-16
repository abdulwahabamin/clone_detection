    /**
     * tells is this queue index is playable or not
     * @param index index to check
     * @param queue list from which it is checked
     * @return boolean for the decision
     */
    public static boolean isIndexPlayable(int index, List<MediaSessionCompat.QueueItem> queue) {
        return queue != null && !((index < 0) || (index >= queue.size()));
    }

