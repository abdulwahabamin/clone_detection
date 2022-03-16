    public static CrashHandler getInstance(Context context) {
        if (null == ourInstance) {
            ourInstance = new CrashHandler(context);
        }

        return ourInstance;
    }

