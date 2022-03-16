	public String[] getFieldNames() {

			TABLE_FIELD_NAMES=new String[TABLE_FIELDS.length];
			for(int i=0; i<TABLE_FIELDS.length; i++) {
				TABLE_FIELD_NAMES[i]=TABLE_FIELDS[i].getName();
			}

		return TABLE_FIELD_NAMES;
	}

