    /**
     * Method that compares {@link FileSystemObject} by MimeTypeCategory
     *
     * @param context The current context
     * @param fso1 File system object 1
     * @param fso2 File system object 2
     * @return int Either -1, 0, 1 based on if fso1 appears before or after fso2
     */
    public static final int compareFSO(Context context, FileSystemObject fso1,
            FileSystemObject fso2) {
        MimeTypeCategory mtc1 = getCategory(context, fso1);
        MimeTypeCategory mtc2 = getCategory(context, fso2);

        return mtc1.compareTo(mtc2);
    }

