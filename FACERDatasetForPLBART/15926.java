    /**
     * Creates a new HandlerThread, starts it and assigns it to a new handler (if not already
     * created).
     */
    synchronized public void createHandler(String handlerName){
        if(!handlerMap.containsKey(handlerName)) {
            HandlerThread handlerThread = new HandlerThread(handlerName);
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handlerMap.put(handlerName, handler);
        }
    }

