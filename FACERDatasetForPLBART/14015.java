    public static synchronized AppWidget42 getInstance() {
        if (sInstance == null) {
            sInstance = new AppWidget42();
        }
        return sInstance;
    }

