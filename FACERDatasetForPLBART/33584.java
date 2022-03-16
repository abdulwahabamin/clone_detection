    /**
     * Creates a new DialogFragment, and sets the provided title and message arguments.
     *
     * @param title   dialog title
     * @param message dialog message; may be null, in which case the message is not displayed
     * @return a new dialog
     */
    public static GeneralDialogFragment newInstance(String title, String message) {
        GeneralDialogFragment fragment = new GeneralDialogFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

