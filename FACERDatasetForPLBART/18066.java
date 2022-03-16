    /**
     * for getting the queueitem from given mediaid
     * @param mediaId input mediaid
     * @param musicProvider musicprovider which provides the music
     * @return list of songs
     */
    public static MediaSessionCompat.QueueItem getQueueItem(@NonNull String mediaId,
                                                            @NonNull MusicProvider musicProvider) {
        String[] hierarchy = MediaIdHelper.getHierarchy(mediaId);
        String musicId = MediaIdHelper.extractMusicIdFromMediaId(mediaId);
        if (musicId != null) {
            MediaMetadataCompat metadata = musicProvider.getMusic(musicId);
            if (metadata == null) {
                return null;
            } else {
                return getQueueItem(metadata, hierarchy);
            }
        }
        return null;
    }

