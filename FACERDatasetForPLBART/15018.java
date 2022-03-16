    /**
     * Creates an empty unspecified CursorLoader.  You must follow this with
     * calls to {@link #setUri(Uri)}, {@link #setSelection(String)}, etc
     * to specify the query to perform.
     */
    public AddIdCursorLoader(Context context) {
        super(context);
        mObserver = new ForceLoadContentObserver();
    }

