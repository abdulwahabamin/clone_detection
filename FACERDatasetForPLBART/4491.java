	private void modifyTableAddColums(ArrayList<DbField> addFields) {
		
		if(addFields!=null && !addFields.isEmpty()) {
			for(DbField field: addFields) {
				StringBuilder sb = new StringBuilder("ALTER TABLE ");
				sb.append(TABLE_NAME);
				sb.append(" ADD COLUMN ");
				sb.append(field.getName());
				sb.append(getSqlFieldType(field));
				
				BLog.e("DB-ALTER",sb.toString());
				db.execSQL(sb.toString());
			}
		}
		
		

	}

