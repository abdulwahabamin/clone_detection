    /**
     * Checks if the operation was cancelled
     *
     * @throws InterruptedException If the operation was cancelled
     */
    private void checkCancelled() throws InterruptedException {
        synchronized (this.mSync) {
            if (this.mCancelled) {
                throw new InterruptedException();
            }
        }
    }

