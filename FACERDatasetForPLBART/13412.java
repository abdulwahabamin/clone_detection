    /**
     * Method that returns the associated mime/type icon resource identifier of
     * the {@link FileSystemObject}.
     *
     * @param context The current context
     * @param fso The file system object
     * @return String The associated mime/type icon resource identifier
     */
    public static final String getIcon(Context context, FileSystemObject fso) {
        return getIcon(context, fso, false);
    }

