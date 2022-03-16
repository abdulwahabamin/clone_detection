	/**
	 * Constructs a fully formed CREATE statement using the input 
	 * parameters.
	 */
	private String buildCreateStatement(String tableName, String[] columnNames, String[] columnTypes) {
		String createStatement = "";
		if (columnNames.length==columnTypes.length) {
			createStatement += "CREATE TABLE IF NOT EXISTS " + tableName + "("
							 + _ID + " INTEGER PRIMARY KEY, ";
			
			for (int i=0; i < columnNames.length; i++) {
				
				if (i==columnNames.length-1) {
					createStatement += columnNames[i] 
							 		+ " "
							 		+ columnTypes[i] 
							 		+ ")";
				} else {
					createStatement += columnNames[i] 
									 + " "
									 + columnTypes[i] 
							 		 + ", ";
				}

			}
			
		}
		
		return createStatement;
	}

