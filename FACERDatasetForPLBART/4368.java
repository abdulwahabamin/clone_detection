	@Override
	public void onResume() {
		super.onResume();
        //BLog.e("RESUME", "Settings resume");
		State.setCurrentSection(State.SECTION_SETTINGS);
        Fab.hide();
        refresh();

	}

