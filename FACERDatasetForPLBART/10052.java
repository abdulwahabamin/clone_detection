    /**
     * Method that returns if the {@code FileSystemObject} can be printed
     *
     * @param ctx The current context
     * @param fso The fso to check
     * @return boolean If the fso can be printed
     */
    public static boolean isPrintedAllowed(Context ctx, FileSystemObject fso) {
        MimeTypeCategory category = MimeTypeHelper.getCategory(ctx, fso);
        String extension = FileHelper.getExtension(fso);
        return category.compareTo(MimeTypeCategory.TEXT) == 0
                || category.compareTo(MimeTypeCategory.IMAGE) == 0
                || (extension != null && extension.toLowerCase().equals(PDF_FILE_EXT));
    }

