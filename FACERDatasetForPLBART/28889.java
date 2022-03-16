    /**
     * @param context           The application context.
     * @param dbHelper          The database helper to use.
     * @param storePersistently Indicates whether to store the requested city permanently.
     */
    public OwmHttpRequestAddCity(Context context, PFASQLiteHelper dbHelper, boolean storePersistently) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.storePersistently = storePersistently;
    }

