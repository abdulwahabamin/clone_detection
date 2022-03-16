    /**
     * Creates a fully-specified, DISTINCT CursorLoader.  See
     * {@link ContentResolver#query(Uri, String[], String, String[], String)
     * ContentResolver.query()} for documentation on the meaning of the
     * parameters.  These will be passed as-is to that call.
     * 
     * boolean dummy is a dummy variable, used to differentiate constructors.
     */
    public SQLiteDBCursorLoader(Context context, boolean distinctGenres, boolean dummy) {
        super(context);
        
        mDistinctGenres = distinctGenres;
        mObserver = new ForceLoadContentObserver();

    }

