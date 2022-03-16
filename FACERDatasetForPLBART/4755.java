	public void onPause() {
		super.onPause();
//		State.addToState(State.SECTION_IMAGES_SLIDER,new StateObject(StateObject.STRING_FILE_PATH,fm.getCurrentDirectory().getAbsolutePath()));
		State.addToState(State.SECTION_IMAGES_SLIDER,new StateObject(StateObject.INT_VALUE,fm.getStartAtPosition()));
        if(amb!=null)
            amb.done();
        pager.removeAllViews();
        pager=null;

	}

