    public MediaMetadataCompat getMusic(String musicId) {
        for (MediaMetadataCompat metadataCompat : musicList) {
            if (musicId.equals(metadataCompat.getDescription().getMediaId())) {
                return metadataCompat;
            }
        }
        return null;
    }

