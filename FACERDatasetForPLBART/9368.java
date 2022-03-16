    /**
     * New data was received
     * @hide
     */
    void onNewData() {
        synchronized (this.mSync) {
            this.mNewData = true;
        }
    }

