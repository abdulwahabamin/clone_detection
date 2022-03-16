	public void refresh() {
        /*
		amb = new ActionModeBack(activity
				, activity.getResources().getString(R.string.label_images)
				,R.menu.image_slider
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {
				//Log.e("OPTIONS", "ACTIONMODE CALL BACK !!!!!!!!!!!!!!!!!!!");
				switch (item.getItemId()) {


					case R.id.menu_share:
						int pos = pager.getCurrentItem();
						File fi = fm.getDirectoryItemAsFile(pos);
						if (fi != null) {
							//this.done();
							BriefActivityManager.shareFile(activity, fi.getAbsolutePath());
						}
						break;
				}
			}
		});
		if(android.os.Build.VERSION.SDK_INT>= 19) {

			ActionBarManager.setActionBarBackV19(activity, amb);
			//setActionBarBackV19();
		} else {
			ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_images), R.menu.image_slider,amb);
		}
        */
		ActionBarManager.hide(activity);

		refreshData();

	}

