    /**
     * {@inheritDoc}
     */
    @Override
    public void dealloc() {
        if (isTrace()) {
            Log.v(TAG, "Deallocating Java console");
        }
        mActive = true;
    }

