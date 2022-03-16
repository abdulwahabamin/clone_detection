    private static final String getMimeTypeFromExtension(final FileSystemObject fso) {
        String ext = FileHelper.getExtension(fso);
        if (ext == null) {
            return null;
        }

        // If this extension is ambiguous, attempt to resolve it.
        String mimeType = getAmbiguousExtensionMimeType(fso.getFullPath(), ext);
        if (mimeType != null) {
            return mimeType;
        }

        //Load from the database of mime types
        MimeTypeInfo mimeTypeInfo = getMimeTypeInternal(fso, ext);
        if (mimeTypeInfo == null) {
            return null;
        }

        return mimeTypeInfo.mMimeType;
    }

