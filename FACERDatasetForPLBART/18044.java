    /**
     * for creating hierarchy aware mediaid
     * @param musicId musicid of song to determine song
     * @param categories categories to determine the list in which the song is present
     * @return built mediaid
     */
    public static String createMediaId(String musicId, String... categories) {
        StringBuilder stringBuilder = new StringBuilder();

        if (categories != null) {
            for (int i=0; i < categories.length; i++) {
                if(!isValidCategory(categories[i])) {
                    throw new IllegalArgumentException("invalid category: "+categories[i]);
                }
                stringBuilder.append(categories[i]);
                if (i < categories.length - 1) {
                    stringBuilder.append(CATEGORY_SEPARATOR);
                }
            }

            if (musicId != null) {
                stringBuilder.append(LEAF_SEPARATOR).append(musicId);
            }
        } else {
            Log.w(TAG, "createMediaId:categories is null");
        }

        return stringBuilder.toString();
    }

