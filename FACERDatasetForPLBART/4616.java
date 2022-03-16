	public void refresh() {

		amb= new ActionModeBack(activity, activity.getResources().getString(R.string.label_delete)
				,R.menu.basic
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {
				//Log.e("AMB", "menuitem actionmodeback: " + mode);

			}
		});
		if(android.os.Build.VERSION.SDK_INT>= 19) {

			ActionBarManager.setActionBarBackV19(activity, amb);
			//setActionBarBackV19();
		} else {
			ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_archive), R.menu.archive,amb);
		}
		refreshData();
		Fab.hide();
	}

