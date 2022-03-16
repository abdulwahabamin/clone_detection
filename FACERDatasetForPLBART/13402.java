    /**
     * Method that converts a not standard media mount path to a standard media path
     *
     * @param path The path to normalize
     * @return String The normalized media path
     */
    public static String normalizeMediaPath(String path) {
        // Retrieve all the paths and check that we have this environment vars
        if (TextUtils.isEmpty(EMULATED_STORAGE_SOURCE) ||
                TextUtils.isEmpty(EMULATED_STORAGE_TARGET) ||
                TextUtils.isEmpty(EXTERNAL_STORAGE)) {
            return path;
        }

        // We need to convert EMULATED_STORAGE_SOURCE -> EMULATED_STORAGE_TARGET
        if (path.startsWith(EMULATED_STORAGE_SOURCE)) {
            path = path.replace(EMULATED_STORAGE_SOURCE, EMULATED_STORAGE_TARGET);
        }
        // We need to convert EXTERNAL_STORAGE -> EMULATED_STORAGE_TARGET / userId
        if (path.startsWith(EXTERNAL_STORAGE)) {
            final String userId = String.valueOf(UserHandle.myUserId());
            final String target = new File(EMULATED_STORAGE_TARGET, userId).getAbsolutePath();
            path = path.replace(EXTERNAL_STORAGE, target);
        }
        return path;
    }

