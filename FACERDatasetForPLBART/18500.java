    /**
     * Creates a fully-specified CursorLoader.  See
     * {@link ContentResolver#query(Uri, String[], String, String[], String)
     * ContentResolver.query()} for documentation on the meaning of the
     * parameters.  These will be passed as-is to that call.
     */
    public SQLiteDBCursorLoader(Context context, String tableName, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        super(context);
        
        mObserver = new ForceLoadContentObserver();
        mTableName = tableName;
        mProjection = projection;
        mSelection = selection;
        mSelectionArgs = selectionArgs;
        mSortOrder = sortOrder;
    }

