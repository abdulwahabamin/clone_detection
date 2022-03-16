    synchronized public void killHandler(final String handlerName) {
        Handler handler = handlerMap.get(handlerName);
        if(handler != null) {
            handlerMap.remove(handlerName);
            handler.getLooper().quit();
        }
    }

