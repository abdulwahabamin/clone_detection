    /**
     * Returns whether the shell shouldn't raise a {@link OperationTimeoutException} when
     * the program didn't exited but new data was received.
     *
     * @return boolean If shell shouldn't raise a {@link OperationTimeoutException} if new
     * data was received
     * @hide
     */
    @SuppressWarnings("static-method")
    public boolean isWaitOnNewDataReceipt() {
        return false;
    }

