    /**
     * �?线程抛出异常时始终调用该方法。主线程�?�有第一次抛出异常时�?会调用该方法，该方法中到的throwable都会上报到bugly。以�?�主线程的异常�?�调用 {@link #onBandageExceptionHappened(Throwable)}
     *
     * @param thread
     * @param throwable
     */
    protected abstract void onUncaughtExceptionHappened(Thread thread, Throwable throwable);

