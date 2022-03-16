    @Override
    public void onPause() {
		Searcher.clear();
		amb.done();
        amb.finish();
        super.onPause();
		//State.setStateLastKnownPosition(State.SECTION_FILE_EXPLORE, list);

    }

