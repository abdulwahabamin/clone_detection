    /**
     * {@inheritDoc}
     */
    @Override
    public void alloc() throws ConsoleAllocException {
        try {
            if (isTrace()) {
                Log.v(TAG, "Allocating " + getName() + " console");
            }
            mActive = true;
        } catch (Exception e) {
            Log.e(TAG, "Failed to allocate " + getName() + " console", e);
            throw new ConsoleAllocException("failed to build console", e);
        }
    }

