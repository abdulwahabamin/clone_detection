    /**
     * {@inheritDoc}
     */
    @Override
    public void onEndParsePartialResult(boolean cancelled) {
        // Send the last partial data
        if (this.mPartial != null && this.mPartial.length() > 0) {
            if (getAsyncResultListener() != null) {
                String data = processPartialResult(this.mPartial);
                if (data != null) {
                    getAsyncResultListener().onPartialResult(data);
                }
            }
        }
        this.mPartial = ""; //$NON-NLS-1$
    }

