    private static final MimeTypeInfo getMimeTypeInternal(String absolutePath,
                                                          String ext,
                                                          boolean firstFound) {
        MimeTypeInfo mimeTypeInfo = null;
        ArrayList<MimeTypeInfo> mimeTypeInfoList = sMimeTypes.get(ext.toLowerCase(Locale.ROOT));
        // Multiple mimetypes map to the same extension, try to resolve it.
        if (mimeTypeInfoList != null && mimeTypeInfoList.size() > 1 && !firstFound) {
            if (absolutePath != null) {
                String mimeType = getAmbiguousExtensionMimeType(absolutePath, ext);
                mimeTypeInfo = sExtensionMimeTypes.get(ext + mimeType);
            } else {
                // We don't have the ability to read the file to resolve the ambiguity,
                // so default to the first available mimetype.
                mimeTypeInfo = mimeTypeInfoList.get(0);
            }
        } else if (mimeTypeInfoList != null && mimeTypeInfoList.size() == 1) {
            // Only one possible mimetype, so pick that one.
            mimeTypeInfo = mimeTypeInfoList.get(0);
        }
        return mimeTypeInfo;
    }

