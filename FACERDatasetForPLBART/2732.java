    public static String renameCopy(String path) {
        String uniquePath = path;

        while (new File(uniquePath).exists()) {
            int extIndex = (uniquePath.lastIndexOf('.'));

            if (extIndex == -1) {
                uniquePath += RENAME_APPEND;
            } else {
                uniquePath = uniquePath.substring(0, extIndex) + RENAME_APPEND + uniquePath.substring(extIndex);
            }

            if (uniquePath.length() > 255) {
                return null;
            }
        }
        return uniquePath;
    }

