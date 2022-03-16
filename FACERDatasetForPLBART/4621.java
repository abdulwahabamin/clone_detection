	private void goPreviousNow() {
		head.setVisibility(View.GONE);
		list.setVisibility(View.GONE);
		//upgrade.setVisibility(View.GONE);
		deleteing.setVisibility(View.GONE);
		completed.setVisibility(View.VISIBLE);
		fm.getSelectedFiles().clear();
		amb.finish();
		//Bgo.goPreviousFragment(activity);
	}

