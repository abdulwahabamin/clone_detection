	private void goPreviousNow() {
		head.setVisibility(View.GONE);
		list.setVisibility(View.GONE);
		//deleteing.setVisibility(View.GONE);
		//completed.setVisibility(View.VISIBLE);
		fm.getSelectedFiles().clear();
        //Log.e("ARCHIVE","Finished ARCHIVE, goPreviousFragment()");
		Bgo.goPreviousFragment(activity);
	}

