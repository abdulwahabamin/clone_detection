    /**Closes all running handlers and their threads*/
    public void closeAllHandlers() {
        HashMap<String, Handler> handlerMap = this.handlerMap;
        this.handlerMap = new HashMap<>();
        for(String handlerName : handlerMap.keySet()) {
            final Handler handler = handlerMap.get(handlerName);
            if(handler != null) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        handler.getLooper().quit();
                    }
                });
            }
        }
    }

