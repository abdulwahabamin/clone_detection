    /**
     * {@inheritDoc}
     */
    @Override
    public void onParsePartialResult(byte[] in) {
        String partialIn = new String(in);
        //If a listener is defined, then send the partial result
        if (partialIn != null && partialIn.length() > 0) {
            if (getAsyncResultListener() != null) {
                getAsyncResultListener().onPartialResult(partialIn);
            }
        }
    }

