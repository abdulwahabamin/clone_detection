    public static String getMusicId(String mediaId) {
        int pos = mediaId.indexOf(LEAF_SEPARATOR);
        if (pos >= 0) {
            String parts[] = mediaId.split(LEAF_SEPARATOR);
            return parts[parts.length-1];
        }
        return "";
    }

