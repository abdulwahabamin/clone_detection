    /**
     * Get the MimeTypeInfo that describes this file.
     * @param absolutePath The absolute path of the file.
     * @param ext The extension of the file.
     * @return The MimeTypeInfo object that describes this file, or null if it cannot be retrieved.
     */
    private static final MimeTypeInfo getMimeTypeInternal(String absolutePath, String ext) {
        return getMimeTypeInternal(absolutePath, ext, false);
    }

