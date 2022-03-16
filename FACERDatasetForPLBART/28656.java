    public static PFASQLiteHelper getInstance(Context context) {
        if (instance == null && context != null) {
            instance = new PFASQLiteHelper(context.getApplicationContext());
        }
        return instance;
    }

