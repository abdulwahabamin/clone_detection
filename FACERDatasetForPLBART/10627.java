    /**
     * Get the MimeTypeInfo that describes this file.
     * @param fso The file.
     * @param ext The extension of the file.
     * @return The MimeTypeInfo object that describes this file, or null if it cannot be retrieved.
     */
    private static final MimeTypeInfo getMimeTypeInternal(FileSystemObject fso, String ext) {
        return getMimeTypeInternal(fso.getFullPath(), ext);
    }

