    @Override
    public boolean onCreate() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        mSQLiteDatabase = dbHelper.getWritableDatabase();
        return mSQLiteDatabase != null;
    }

