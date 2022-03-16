    public synchronized static MozillaLocationService getInstance(Context context) {
        if (instance == null) {
            instance = new MozillaLocationService();
            instance.context = context.getApplicationContext();
        }
        return instance;
    }

