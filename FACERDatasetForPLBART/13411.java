    /**
     * Method that checks whether a certain mime type is known to
     * the application.
     *
     * @param context The current context
     * @param mimeType The mime type to be checked
     * @return true if mime type is known, false otherwise
     */
    public static final boolean isMimeTypeKnown(Context context, String mimeType) {
        //Ensure that mime types are loaded
        if (sMimeTypes == null) {
            loadMimeTypes(context);
        }

        if (mimeType == null) {
            return false;
        }

        for (ArrayList<MimeTypeInfo> mimeTypeInfoList : sMimeTypes.values()) {
            for (MimeTypeInfo info : mimeTypeInfoList) {
                String mimeTypeRegExp = convertToRegExp(mimeType);
                if (info.mMimeType.matches(mimeTypeRegExp)) {
                    return true;
                }
            }
        }

        return false;
    }

