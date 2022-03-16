    /**
     * {@inheritDoc}
     */
    @Override
    public void onParseErrorPartialResult(byte[] in) {
        String partialErr = new String(in);
        //If a listener is defined, then send the partial result
        if (partialErr != null && partialErr.length() > 0) {
            if (getAsyncResultListener() != null) {
                getAsyncResultListener().onPartialResult(partialErr);
            }
        }
    }

