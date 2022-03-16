	protected String getSqlFieldType(DbField field) {
		StringBuilder sb = new StringBuilder(" ");
		switch(field.getFieldType()) {
			case DbField.FIELD_TYPE_TEXT:
				sb.append("TEXT");
				break;
			case DbField.FIELD_TYPE_INT:
				sb.append("INTEGER");
				if(field.isPrimary())
					sb.append(" PRIMARY KEY AUTOINCREMENT");
				break;
			case DbField.FIELD_TYPE_FLOAT:
				sb.append("REAL");
				break;
			case DbField.FIELD_TYPE_BLOB:
				sb.append("BLOB");
				break;
			default:
				break;
		}
		return sb.toString();
	}

