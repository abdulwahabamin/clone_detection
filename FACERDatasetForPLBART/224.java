    public static ClientService getInstance(Handler handler) {
        mainHandler = handler;

        if (instance == null) {
            Log.i(TAG, "instance is null");
            synchronized (ClientService.class) {
                if (instance == null) {
                    instance = new ClientService();
                }
            }
        }

        return instance;

    }

