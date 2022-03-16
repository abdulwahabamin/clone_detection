    /**
     * tells if the provider is initialized or not
     * @return true if initialized else false
     */
    public boolean isInitialized() {
        return this.mCurrentState == MusicProvider.State.INITIALIZED;
    }

