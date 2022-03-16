	public void refresh() {
		String sob = State.getStateObjectString(State.SECTION_FILE_EXPLORE, StateObject.STRING_FILE_PATH);
		if(sob!=null) {
			//BLog.e("file manager refresh called: " + sob);
			fm.setCurrentDirectory(activity, sob);

		}



        refreshData();

	}

