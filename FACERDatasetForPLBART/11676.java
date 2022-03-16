    /**
     * Method that communicates that a new partial result parse will start.
     * @hide
     */
    public final void onRequestStartParsePartialResult() {
        this.mWorkerThread = new AsyncResultProgramThread();
        this.mWorkerThread.start();

        //Notify start to command class
        this.onStartParsePartialResult();

        //If a listener is defined, then send the start event
        if (getAsyncResultListener() != null) {
            getAsyncResultListener().onAsyncStart();
        }
    }

