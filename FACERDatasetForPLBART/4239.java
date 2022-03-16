	public void refresh() {

		//BriefMenu.hideMenu();
		//ActionBarManager.setActionBarBackOnly(getActivity(), activity.getResources().getString(R.string.label_search), R.menu.accounts);

		adapter=new SearchAdapter(getActivity()); 
        list.setAdapter(adapter);
        list.setOnItemClickListener(openListener);
			
        run.brief.b.bButton searchnow=(run.brief.b.bButton) activity.findViewById(R.id.search_btn);
        searchnow.setClickable(true);
        searchnow.setOnClickListener(newSearchListener);
        
		searchText=(EditText) activity.findViewById(R.id.search_text);


		Device.setKeyboard(activity, searchText, true);
		Fab.hide();
		//view.requestFocus();
	}

