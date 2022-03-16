    @Override
    public void refresh() {
        if( mListView != null ) {
            getLoaderManager().restartLoader(0, null, this);
        }
    }

