    @Override
    public synchronized Future<Weather> setOtherTask(Callable<Weather> callable) {
        Future<Weather> future = null;
        if (callable != null && !mShutdowned) {
            future = submit(callable);
        }
        return future;
    }

