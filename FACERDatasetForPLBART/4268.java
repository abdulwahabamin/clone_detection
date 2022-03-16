	@Override
	public void onResume() {
		super.onResume();

		State.setCurrentSection(State.SECTION_SEARCH_SHORTCUT);

		String sob = State.getStateObjectString(State.SECTION_SEARCH_SHORTCUT,StateObject.STRING_BJSON_OBJECT);
		//Log.e("SOB","sob: "+sob );
		if(sob!=null) {
			packet = new SearchPacket(new JSONObject(sob));

		}
        list=(ListView) view.findViewById(R.id.search_list);
		foldersView = (LinearLayout) view.findViewById(R.id.search_list_folders);

		start = (View) view.findViewById(R.id.search_start);
		updating = (View) view.findViewById(R.id.search_updating);
		adapter=new SearchShortcutAdapter(activity,list);


		amb = new ActionModeBack(activity, activity.getResources().getString(R.string.label_search)
				,R.menu.search_shortcut
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {
                onOptionsItemSelected(item);
			}
		});
        if(android.os.Build.VERSION.SDK_INT>= 19) {

            ActionBarManager.setActionBarBackV19(activity, amb);
            //setActionBarBackV19();
        } else {
            ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_search), R.menu.search_shortcut,amb);
        }
		//searchHeader=activity.findViewById(R.id.search_tools);
		//searchHeader.setVisibility(View.GONE);
		loading = activity.findViewById(R.id.loading);
		if(packet!=null) {

			loading.setVisibility(View.VISIBLE);
			openSearchShort=new OpenSearchShort();
			openSearchShort.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
		} else {
			refresh();
		}

		Fab.hide();


	}

