	public Db(String TABLE_NAME, DbField[] TABLE_FIELDS, Context context) {
		this.TABLE_NAME=TABLE_NAME;
		this.TABLE_FIELDS=TABLE_FIELDS;
		this.context=context;
		open();
		ensureTable(context);
	}

