    /**
     * for getting playing queue according to mediaid
     * @param mediaId input mediaid
     * @param musicProvider musicprovider which provides the music
     * @return list from given mediaid
     */
    public static List<MediaSessionCompat.QueueItem> getPlayingQueue(@NonNull String mediaId,
                                                                     @NonNull MusicProvider musicProvider,
                                                                     @NonNull PlaylistsManager playlistsManager) {
        Log.d(TAG, "getPlayingQueue:called");
        Log.i(TAG, "getPlayingQueue:id="+mediaId);

        List<MediaSessionCompat.QueueItem> playingQueue = new ArrayList<>();
        String[] hierarchy = MediaIdHelper.getHierarchy(mediaId);

        String temp = "";
        for (String t : hierarchy) {
            temp+="["+t+"]";
        }
        Log.i(TAG, "getPlayingQueue:hierarchy="+temp);

        switch (hierarchy[0]) {
            case MediaIdHelper.MEDIA_ID_ALL_SONGS:
                for (MediaMetadataCompat metadata : musicProvider.getSongs()) {
                    playingQueue.add(getQueueItem(metadata, MediaIdHelper.MEDIA_ID_ALL_SONGS));
                }
                break;
            case MediaIdHelper.MEDIA_ID_ALBUMS:
                for (MediaMetadataCompat metadata : musicProvider.getMusicsByAlbumKey(hierarchy[1])) {
                    playingQueue.add(getQueueItem(metadata, hierarchy));
                }
                break;
            case MediaIdHelper.MEDIA_ID_ARTISTS:
                for (MediaMetadataCompat metadata : musicProvider.getMusicsByArtistKey(hierarchy[1])) {
                    playingQueue.add(getQueueItem(metadata, hierarchy));
                }
                break;
            case MediaIdHelper.MEDIA_ID_PLAYLISTS:
                for (MediaMetadataCompat metadata : playlistsManager.getMusicsByPlaylistKey(hierarchy[1])) {
                    playingQueue.add(getQueueItem(metadata, hierarchy));
                }
                break;
        }

        return playingQueue;
    }

