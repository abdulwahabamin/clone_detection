	public static void init() {
		if(E.data==null) {
			FileReadTask frt = new FileReadTask(Files.HOME_PATH_APP, Files.FILENAME_SEARCH_HISTORY);
			if(frt.ReadSecureFromSd()) {
				try {
					JSONObject db = new JSONObject(frt.getFileContent());
					if(db!=null) {
						E.data = db.getJSONArray(DB_ROOT);
						E.isInitialised=true;
					}
				} catch(JSONException e) {}
			}
		}
		if(!E.isInitialised) {
			E.data = new JSONArray();
			E.isInitialised=true;
		}
	}

