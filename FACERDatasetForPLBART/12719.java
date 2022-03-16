    /**
     * Constructor of <code>InputNameDialog</code>.
     *
     * @param context The current context
     * @param files The files of the current directory (used to validate the name)
     * @param dialogTitle The dialog title
     */
    public InputNameDialog(
            final Context context, String parent, String dialogTitle) {
        this(context, parent, null, false, dialogTitle);
    }

