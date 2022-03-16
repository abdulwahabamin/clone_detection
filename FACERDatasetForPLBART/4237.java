	@Override
	public void onResume() {
		super.onResume();
		State.setCurrentSection(State.SECTION_SEARCH);
		start = (View) view.findViewById(R.id.search_start);
		updating = (View) view.findViewById(R.id.search_updating);
		

        list=(ListView) activity.findViewById(R.id.search_list);
		amb = new ActionModeBack(activity, activity.getResources().getString(R.string.label_search)
				,R.menu.search
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {

			}
		});
        if(android.os.Build.VERSION.SDK_INT>= 19) {

            ActionBarManager.setActionBarBackV19(activity, amb);
            //setActionBarBackV19();
        } else {
            ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_search), R.menu.image_slider,amb);
        }
		refresh();
		

	}

