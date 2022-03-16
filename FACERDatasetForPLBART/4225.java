    public static void doSearchShortcut(Context context, int type, BCallback callback) {


        IndexerDb.init(context);
        results = IndexerDb.searchByCategory(type);

        if(callback!=null)
            callback.callback();
    }

