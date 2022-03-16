    /**
     * Method that converts a content uri to a file system path
     *
     * @param cr The content resolver
     * @param uri The content uri
     * @return File The file reference
     */
    public static File contentUriToFile(ContentResolver cr, Uri uri) {
        // Sanity checks
        if (uri == null || uri.getScheme() == null || uri.getScheme().compareTo("content") != 0) {
            return null;
        }

        // Retrieve the request id
        long id = 0;
        try {
            id = Long.parseLong(new File(uri.getPath()).getName());
        } catch (NumberFormatException nfex) {
            return null;
        }

        // Check in external and internal storages
        File file = mediaIdToFile(cr, id, EXTERNAL_VOLUME);
        if (file != null) {
            return file;
        }
        file = mediaIdToFile(cr, id, INTERNAL_VOLUME);
        if (file != null) {
            return file;
        }
        return null;
    }

