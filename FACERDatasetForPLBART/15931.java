    public void executeWhenIdle(String handlerName, final Runnable r, final boolean executeOnce) {
        final MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                r.run();
                return !executeOnce;
            }
        };

        Handler handler = handlerMap.get(handlerName);
        if(handler != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Looper.myQueue().addIdleHandler(idleHandler);
                }
            });
        }
    }

