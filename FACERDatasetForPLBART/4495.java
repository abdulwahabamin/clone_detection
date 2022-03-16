	public DbField(String name, int FIELD_TYPE, boolean isPrimaryKey, boolean indexIfNotPrimary){
		this.NAME=name;
		this.FIELD_TYPE=FIELD_TYPE;
		this.PRIMARY_KEY=isPrimaryKey;
		this.HAS_INDEX=indexIfNotPrimary;
	}

