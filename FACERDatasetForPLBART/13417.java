    /**
     * Gets the mimetype of a file, if there are multiple possibilities given it's extension.
     * @param absolutePath The absolute path of the file for which to find the mimetype.
     * @param ext The extension of the file.
     * @return The correct mimetype for this file, or null if the mimetype cannot be determined
     * or is not ambiguous.
     */
    private static final String getAmbiguousExtensionMimeType(String absolutePath, String ext) {
        if (AmbiguousExtensionHelper.AMBIGUOUS_EXTENSIONS_MAP.containsKey(ext)) {
            AmbiguousExtensionHelper helper =
                    AmbiguousExtensionHelper.AMBIGUOUS_EXTENSIONS_MAP.get(ext);
            String mimeType = helper.getMimeType(absolutePath, ext);
            if (!TextUtils.isEmpty(mimeType)) {
                return mimeType;
            }
        }
        return null;
    }

