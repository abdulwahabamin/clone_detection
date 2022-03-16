    /**
     * {@inheritDoc}
     */
    @Override
    public void onPartialResult(final Object result) {
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                setChecksum(String.valueOf(result));
            }
        });
    }

