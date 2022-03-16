	@Override
	public boolean onCreate() {
		dbHelper = new DatabaseHelper(getContext());
        db = dbHelper.getWritableDatabase();
        return (db == null)? false:true;
	}

