    @Override
    protected void onLooperPrepared() {
        mConcurrentMap = new ConcurrentHashMap<>();
        mDataPool.prestartCoreThread();
        mHandlerAnswer = new HandlerRequest<>(this, Looper.myLooper());
    }

