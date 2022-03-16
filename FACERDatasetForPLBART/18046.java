    /**
     * for extracting musicid from hierarchy aware mediaid
     * @param mediaId given hierarchy aware mediaid
     * @return musicid
     */
    public static String extractMusicIdFromMediaId(@NonNull String mediaId) {
        int pos = mediaId.indexOf(LEAF_SEPARATOR);
        if (pos >= 0) {
            return mediaId.substring(pos + LEAF_SEPARATOR.length());
        }
        return null;
    }

