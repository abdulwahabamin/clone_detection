    /**
     * Takes a runnable and handler name, calls create Handler to create the handler and executes
     * the task on that thread.
     *
     * Note: Remember to close all handlers before destroying this object!
     */
    public void executeAsync(Runnable r, final String handlerName) {
        createHandler(handlerName);
        Handler handler = handlerMap.get(handlerName);
        handler.post(r);
    }

