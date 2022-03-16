    /**
     * Constructor of <code>InputNameDialog</code>.
     *
     * @param context The current context
     * @param files The files of the current directory (used to validate the name)
     * @param dialogTitle The dialog title
     */
    public InputNameDialog(
            final Context context, List<FileSystemObject> files, String dialogTitle) {
        this(context, files, null, false, dialogTitle);
    }

