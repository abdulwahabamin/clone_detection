    /**
     * for getting the categories/hierarchy of the given song according to its mediaid
     * @param mediaID input hierarchy aware mediaid
     * @return string array of categories/hierarchy
     */
    public static @NonNull String[] getHierarchy(@NonNull String mediaID) {
        int pos = mediaID.indexOf(LEAF_SEPARATOR);
        if (pos >= 0) {
            mediaID = mediaID.substring(0, pos);
        }
        return mediaID.split(String.valueOf(CATEGORY_SEPARATOR));
    }

