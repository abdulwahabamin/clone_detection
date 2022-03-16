	@Override
	public void onPause() {
		super.onPause();

		recheckArchingstatus.removeCallbacks(runCheckingArchive);
		//BLog.e("SAVE: " + fm.getCurrentDirectory().getAbsolutePath());
		State.addToState(State.SECTION_FILE_EXPLORE_ARCHIVE, new StateObject(StateObject.STRING_FILE_PATH, fm.getCurrentDirectory().getAbsolutePath()));
        State.addToState(State.SECTION_FILE_EXPLORE_ARCHIVE, new StateObject(StateObject.INT_MODE,mode));
        if(amb!=null)
			amb.done();
        //amb.mMode.finish();


	}

