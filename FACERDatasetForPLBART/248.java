    public static ServerService getInstance(Handler handler) {
        mainHandler = handler;

        if (instance == null) {
            Log.i(TAG, "server instance is null");
            synchronized (ServerService.class) {
                if (instance == null) {
                    instance = new ServerService();
                }
            }
        }

        return instance;

    }

