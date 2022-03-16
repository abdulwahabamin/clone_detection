    /**
     * {@inheritDoc}
     */
    @Override
    public void onParsePartialResult(byte[] in) {
        //If a listener is defined, then send the partial result
        if (in != null && in.length > 0) {
            if (getAsyncResultListener() != null) {
                getAsyncResultListener().onPartialResult(in);
            }
        }
    }

