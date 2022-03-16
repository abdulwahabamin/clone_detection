    public ReadaheadThread() {
        mScratch = new byte[BYTES_PER_READ];
        HandlerThread handlerThread = new HandlerThread("ReadaheadThread", Process.THREAD_PRIORITY_LOWEST);
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper(), this);
    }

