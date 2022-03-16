	@Override
	public void onPause() {
		super.onPause();

		State.addToState(State.SECTION_FILE_EXPLORE, new StateObject(StateObject.INT_LISTVIEW_FIRST_VIEWABLE, list.getFirstVisiblePosition()));
		if(adapterImages!=null) {

			ImageCache.clearCache();
            adapterImages=null;

		}
		State.addToState(State.SECTION_FILE_EXPLORE,new StateObject(StateObject.STRING_FILE_PATH,fm.getCurrentDirectory().getAbsolutePath()));
		processMessageHandler.removeCallbacks(processMessagerunnable);
        State.setStateLastKnownPosition(State.SECTION_FILE_EXPLORE,list);
	}

