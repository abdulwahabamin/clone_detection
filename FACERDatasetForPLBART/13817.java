    public static DBHandler getInstance(Context ctx) {

        if (mInstance == null) {
            mInstance = new DBHandler(ctx.getApplicationContext());
        }
        return mInstance;
    }

