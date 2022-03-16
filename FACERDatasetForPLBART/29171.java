    public FetchThreadData(Handler handler) {
        super(TAG);
        int cores = Runtime.getRuntime().availableProcessors();
        mDataPool = new WeatherDataPool(cores, cores * 2 + 1,
                5, TimeUnit.SECONDS, mArrayBlockingQueue);
            mTasker = (CallableTasker) mDataPool;
            mMainThreadCallback = handler;

    }

