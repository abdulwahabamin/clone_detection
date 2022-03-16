	public void onPause() {
        State.addToState(State.SECTION_FILE_CREATE_ARCHIVE, new StateObject(StateObject.STRING_FILE_PATH, fm.getCurrentDirectory().getAbsolutePath()));
        State.addToState(State.SECTION_FILE_CREATE_ARCHIVE, new StateObject(StateObject.STRING_BJSON_OBJECT, fm.getSelectedFilesAsJSONArray().toString()));
		super.onPause();
		if(amb!=null)
			amb.done();
	}

