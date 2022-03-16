    /**
     * Method invoked when an object want to be part of this concurrent listener
     */
    public void onRegister() {
        synchronized (mSync) {
            mRefs++;
        }
    }

