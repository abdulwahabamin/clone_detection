    /**
     * Safely close all handlersQuits a specific handler's looper. The task of quitting the thread
     * is posted onto that thread's queue itself so that any remaining tasks finish first (since
     * quitSafely() is unavailable below sdk 18).
     */
    synchronized public void closeHandler(final String handlerName) {
        final Handler handler = handlerMap.get(handlerName);
        if(handler != null) {
            handlerMap.remove(handlerName);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    handler.getLooper().quit();
                }
            });
        }
    }

