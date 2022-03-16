	public static boolean Save() {

		if(!E.isInitialised)
			init();
		if(E.data.length()!=0) {
			JSONObject db = new JSONObject();
			try {
				db.put(DB_ROOT, E.data);
				FileWriteTask frt=new FileWriteTask(Files.HOME_PATH_APP, Files.FILENAME_SEARCH_HISTORY, db.toString());
				return frt.WriteToSd();
			} catch(Exception e) {}
		}

		return false;
	}

