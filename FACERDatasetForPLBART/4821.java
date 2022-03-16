	private void showHideMessage() {
		TextView pop = (TextView) activity.findViewById(R.id.main_pop_message);
		if(pop!=null) {
			if(BrowseService.isUnArchiving()) {

				if(fm.isCurrentDirImages()) {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.white_alpha));
				} else {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha));
                }
                pop.setText(BrowseService.getCurrentUnArchiveCount() + "/" + BrowseService.getCurrentUnArchiveTotal() + " - Extracting archive ");
				pop.setVisibility(View.VISIBLE);
				pop.bringToFront();
				//fab.bringToFront();
				recheckArchingstatus.postDelayed(runCheckingArchive,100);
			} else {
				pop.setVisibility(View.GONE);
                pop.setText("");
                State.addToState(State.SECTION_FILE_EXPLORE, new StateObject(StateObject.STRING_FILE_PATH, extractToFolder));
                if(started) {
                    amb.done();
                    Bgo.goPreviousFragment(activity);
                }
			}
		}
	}

