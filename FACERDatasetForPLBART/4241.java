		@Override
		public void onClick(View view) {

			//Log.e("SEARCH","SEARCH FOR: "+searchText.getText().toString());
			start.setVisibility(View.GONE);
			updating.setVisibility(View.VISIBLE);
			Searcher.doSearch(activity, searchText.getText().toString(), searchCallback);

			SearchHistory.add(new SearchPacket(0, 0, searchText.getText().toString()));
			SearchHistory.Save();

			list.setAdapter(new SearchAdapter(getActivity()));
			Device.hideKeyboard(activity);
		}

