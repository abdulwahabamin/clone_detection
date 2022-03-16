    @Override
    public void onResume() {
        super.onResume();
        // Starts a new or restarts an existing Loader in this manager
        getLoaderManager().restartLoader(0, null, this);
    }

