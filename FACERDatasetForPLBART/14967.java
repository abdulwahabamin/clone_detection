    public static synchronized AppWidget11 getInstance() {
        if (sInstance == null) {
            sInstance = new AppWidget11();
        }
        return sInstance;
    }

