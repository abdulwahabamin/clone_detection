    /**
     * Method that returns the mime/type category of the file.
     *
     * @param context The current context
     * @param ext The extension of the file
     * @param absolutePath The absolute path of the file. Can be null if not available.
     * @return MimeTypeCategory The mime/type category
     */
    public static final MimeTypeCategory getCategoryFromExt(Context context, String ext,
                                                            String absolutePath) {
        // Ensure that have a context
        if (context == null && sMimeTypes == null) {
            // No category
            return MimeTypeCategory.NONE;
        }
        //Ensure that mime types are loaded
        if (sMimeTypes == null) {
            loadMimeTypes(context);
        }
        if (ext != null) {
            //Load from the database of mime types
            MimeTypeInfo mimeTypeInfo = getMimeTypeInternal(absolutePath, ext);
            if (mimeTypeInfo != null) {
                return mimeTypeInfo.mCategory;
            }
        }

        // No category
        return MimeTypeCategory.NONE;
    }

