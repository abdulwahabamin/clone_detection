    /**
     * for getting hierarchy id from a mediaid
     * @param mediaID input hierarchy aware mediaid
     * @return string hierarchyid
     */
    public static @NonNull String getHierarchyId(@NonNull String mediaID) {
        int pos = mediaID.indexOf(LEAF_SEPARATOR);
        if (pos >= 0) {
            mediaID = mediaID.substring(0, pos);
        }
        return mediaID;
    }

