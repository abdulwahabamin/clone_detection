    private static boolean isSong(String mimeType) {
        return mimeType == null ||
                mimeType.startsWith("audio/") ||
                mimeType.equals("application/ogg") ||
                mimeType.equals("application/x-ogg");
    }

