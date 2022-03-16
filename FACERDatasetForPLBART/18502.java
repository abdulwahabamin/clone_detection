    /**
     * Creates a fully-specified, DISTINCT CursorLoader.  See
     * {@link ContentResolver#query(Uri, String[], String, String[], String)
     * ContentResolver.query()} for documentation on the meaning of the
     * parameters.  These will be passed as-is to that call.
     */
    public SQLiteDBCursorLoader(Context context, boolean distinctPlaylists) {
        super(context);
        
        mDistinctPlaylists = distinctPlaylists;
        mObserver = new ForceLoadContentObserver();

    }

