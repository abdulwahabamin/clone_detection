	public static void doSearchFolderByCat(Context context, int cat, BCallback callback) {


		IndexerDb.init(context);
		results = IndexerDb.getDb().getFoldersByCategory(cat, 0, 200);

		if(callback!=null)
			callback.callback();
	}

