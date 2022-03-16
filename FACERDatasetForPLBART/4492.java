	private void createTable() {
		//isFirstTimeRun=true;
		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(TABLE_NAME);
		sb.append(" (");
		for(int i=0; i<TABLE_FIELDS.length; i++) {
			if(i!=0)
				sb.append(", ");
			sb.append(TABLE_FIELDS[i].getName());
			sb.append(getSqlFieldType(TABLE_FIELDS[i]));
		}
		sb.append(")");
		//BLog.e("DBCREATETABLE",sb.toString());
		db.execSQL(sb.toString());
		for(int i=0; i<TABLE_FIELDS.length; i++) {
			DbField f = TABLE_FIELDS[i];
			if(f.hasIndex()) {
				String index="CREATE INDEX "+TABLE_NAME+"_"+f.getName()+" ON "+TABLE_NAME+"("+f.getName()+")";
				db.execSQL(index);
				//Log.e("DB_INDEX_TABLE",index);
			}
		}
	}

