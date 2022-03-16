    public MessageDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        this.myContext = context;

        this.DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        Log.e("Path 1", DB_PATH);
    }

