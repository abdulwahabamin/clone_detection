	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		parentActivity = getActivity();
		dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag("customizeScreensDialog");
		
		sharedPreferences = parentActivity.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
		rootView = (View) parentActivity.getLayoutInflater().inflate(R.layout.customize_screens_layout, null);
		
		customizeScreensText = (TextView) rootView.findViewById(R.id.customize_screens_text);
		customizeScreensText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		customizeScreensText.setPaintFlags(customizeScreensText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		//Populate the arraylists with the settings saved in SharedPreferences.
		page1 = sharedPreferences.getString("PAGE_1", getResources().getString(R.string.artists_caps));
		page2 = sharedPreferences.getString("PAGE_2", getResources().getString(R.string.albums_caps));
		page3 = sharedPreferences.getString("PAGE_3", getResources().getString(R.string.songs_caps));
		page4 = sharedPreferences.getString("PAGE_4", getResources().getString(R.string.playlists_caps));
		page5 = sharedPreferences.getString("PAGE_5", getResources().getString(R.string.genres_caps));
		page6 = sharedPreferences.getString("PAGE_6", getResources().getString(R.string.folders_caps));
		
		if (!page1.equals("null") || !page1.equals(null)) {
			screenTitlesList.add(page1);
		}
		
		if (!page2.equals("null") || !page2.equals(null)) {
			screenTitlesList.add(page2);
		}
		
		if (!page3.equals("null") || !page3.equals(null)) {
			screenTitlesList.add(page3);
		}
		
		if (!page4.equals("null") || !page4.equals(null)) {
			screenTitlesList.add(page4);
		}
		
		if (!page5.equals("null") || !page5.equals(null)) {
			screenTitlesList.add(page5);
		}
		
		if (!page6.equals("null") || !page6.equals(null)) {
			screenTitlesList.add(page6);
		}

		listView = (DragSortListView) rootView.findViewById(R.id.customize_screens_listview);
		adapter = new CustomizeScreensListAdapter(parentActivity, screenTitlesList);
		listView.setAdapter(adapter);
		listView.setDropListener(onDrop);
		SimpleFloatViewManager simpleFloatViewManager = new SimpleFloatViewManager(listView);
		simpleFloatViewManager.setBackgroundColor(Color.TRANSPARENT);
		listView.setFloatViewManager(simpleFloatViewManager);
			
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.customize_screens);
        builder.setView(rootView);
        builder.setPositiveButton(R.string.done, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialogFragment.dismiss();
				
				//adapter.getItem(i) will get us the order for the screens.
				sharedPreferences.edit().putString("PAGE_1", adapter.getItem(0).toString().toUpperCase()).commit();
				sharedPreferences.edit().putString("PAGE_2", adapter.getItem(1).toString().toUpperCase()).commit();
				sharedPreferences.edit().putString("PAGE_3", adapter.getItem(2).toString().toUpperCase()).commit();
				sharedPreferences.edit().putString("PAGE_4", adapter.getItem(3).toString().toUpperCase()).commit();
				sharedPreferences.edit().putString("PAGE_5", adapter.getItem(4).toString().toUpperCase()).commit();
				sharedPreferences.edit().putString("PAGE_6", adapter.getItem(5).toString().toUpperCase()).commit();
				
				Toast.makeText(parentActivity, R.string.changes_saved, Toast.LENGTH_SHORT).show();
				
				//Restart the app.
				Intent i = parentActivity.getBaseContext()
										 .getPackageManager()
										 .getLaunchIntentForPackage(parentActivity.getBaseContext()
												 								  .getPackageName());
				
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				dialogFragment.dismiss();
				getActivity().finish();
				startActivity(i);
				
			}
        	
        });

        return builder.create();
    }

