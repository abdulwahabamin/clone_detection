	private void showHideMessage() {
		TextView pop = (TextView) activity.findViewById(R.id.main_pop_message);
		if(pop!=null) {
			if(BrowseService.isArchiving()) {
				if(fm.isCurrentDirImages()) {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.white_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.black));
				} else {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.white));
				}
				pop.setText(BrowseService.getCurrentArchiveCount() + "/" + BrowseService.getCurrentArchiveTotal() + " - "+getString(R.string.creating_archive)+": " + BrowseService.getCurrentArhiveFileItem().getName());
				pop.setVisibility(View.VISIBLE);
				pop.bringToFront();
				if(fab!=null)
					fab.bringToFront();
				processMessageHandler.postDelayed(processMessagerunnable, 500);
			} else 	if(BrowseService.isMoving()) {

				if(fm.isCurrentDirImages()) {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.white_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.black));
				} else {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.white));
				}
				pop.setText(getString(R.string.label_moving));
				pop.setVisibility(View.VISIBLE);
				pop.bringToFront();
				if(fab!=null)
					fab.bringToFront();
				processMessageHandler.postDelayed(processMessagerunnable, 500);
			}  else if(BrowseService.isPasting()) {

				if(fm.isCurrentDirImages()) {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.white_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.black));
				} else {
					pop.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha));
					pop.setTextColor(activity.getResources().getColor(R.color.white));
				}
				pop.setText(getString(R.string.label_paste_files));
				pop.setVisibility(View.VISIBLE);
				pop.bringToFront();
				if(fab!=null)
					fab.bringToFront();
				processMessageHandler.postDelayed(processMessagerunnable, 500);
			} else {
				pop.setVisibility(View.GONE);
				pop.setText("");
			}
		}
	}

