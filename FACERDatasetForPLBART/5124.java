	public static void add(String errorString) {
		if(E.isDebug) {
			if(!E.isInitialised)
				init();
			LimitSizeForAdd();
			try {
				E.data.put(E.data.length(),Cal.getCal().friendlyReadDate()+" - "+errorString);
			} catch(Exception e) {
				//Log.e("LOG ERROR", "Failed add");
			}
		}
	}

