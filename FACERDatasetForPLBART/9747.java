    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreate() {
        this.mOpenHelper = new BookmarksDatabaseHelper(getContext());
        return true;
    }

