    /**
     * 当原本导致app崩溃的主线程异常�?�生�?�，主线程�?次抛出导致app崩溃异常时会调用该方法。（自己try catch�?的异常�?会导致app崩溃）
     * （该方法中到的throwable�?会上报到bugly，也无需上报到bugly，因为本次异常�?�能是由于第一次主线程异常时app没有崩溃掉�?�?�生的，�?��?修�?了bug就�?会�?�生该异常了)
     *
     * @param throwable 主线程的异常
     */
    protected abstract void onBandageExceptionHappened(Throwable throwable);

