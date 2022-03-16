	public static void add(SearchPacket packet) {

		if(!E.isInitialised)
			init();
		LimitSizeForAdd();
		try {
			E.data.put(E.data.length(),packet);
		} catch(Exception e) {
			//Log.e("LOG ERROR", "Failed add");
		}

	}

