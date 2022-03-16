    /**
     * Appends a list of tracks to the current playlist.
     * If nothing is playing currently, playback will be started at
     * the first track.
     * If the action is NOW, playback will switch to the first of
     * the new tracks immediately.
     *
     * @param list   The list of tracks to append.
     * @param action NOW, NEXT or LAST
     */
    void enqueue(long[] list, int action);

