    /**
     * @see ResultReceiver#onReceiveResult(int, Bundle)
     */
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }

