    public static DataSourceManager getInstance(Context context) {
        if (null == ourInstance) {
            ourInstance = new DataSourceManager(context);
        }
        return ourInstance;
    }

