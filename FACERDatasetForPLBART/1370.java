    /**
     * Stops the RFCOMM Socket
     */
    public void stopRfcommService(){
        if (mInsecureAcceptThread != null) {
            mInsecureAcceptThread.end();
        }
        mInsecureAcceptThread = null;
    }

