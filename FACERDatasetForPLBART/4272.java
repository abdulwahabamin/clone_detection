	public void refresh() {

		//BriefMenu.hideMenu();
		//ActionBarManager.setActionBarBackOnly(getActivity(), activity.getResources().getString(R.string.label_search), R.menu.accounts);
		adapter.notifyDataSetInvalidated();

        list.setAdapter(adapter);
        list.setOnItemClickListener(openListener);
		//State.setStateLastKnownPosition(State.SECTION_FILE_EXPLORE, list);
        list.setSelection(State.getFolderPosition("searcher"));
        amb.mMode.setTitle(packet.getString(SearchPacket.STRING_TERM));


        foldersView.removeAllViews();
        if(folders!=null && !folders.isEmpty()) {
            LinearLayout.LayoutParams rlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int size = Functions.dpToPx(40, activity);
            int tsize = Functions.dpToPx(90, activity);
            LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(tsize, LinearLayout.LayoutParams.WRAP_CONTENT);
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(size, size);
            for (final IndexerFile ifile : folders) {
                LinearLayout rlay = new LinearLayout(activity);
                rlay.setOrientation(LinearLayout.VERTICAL);
                rlay.setGravity(Gravity.CENTER_HORIZONTAL);
                rlay.setLayoutParams(rlp);

                ImageView img = new ImageView(activity);
                img.setLayoutParams(lp);
                img.setImageDrawable(getResources().getDrawable(Files.getFoldersRIcon(ifile.getInt(IndexerFile.INT_CATEGORY))));

                TextView txtx = new TextView(activity);
                txtx.setPadding(3, 0, 3, 0);
                txtx.setLayoutParams(tlp);
                txtx.setTextSize(11f);
                txtx.setGravity(Gravity.CENTER_HORIZONTAL);
                txtx.setText(Sf.restrictLength(ifile.getString(IndexerFile.STRING_FILENAME), 12));
                rlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //amb.done();
                        //State.sectionsClearBackstack();
                        BLog.e(ifile.absoluteFile() + " --- " + ifile.getString(IndexerFile.STRING_FILENAME));
                        State.addToState(State.SECTION_FILE_EXPLORE, new StateObject(StateObject.STRING_FILE_PATH, ifile.absoluteFile()));
                        //Bgo.openFragmentBackStack(activity,new FileExploreFragment());
                        Bgo.goPreviousFragment(activity);
                    }
                });

                rlay.addView(img);
                rlay.addView(txtx);
                foldersView.addView(rlay);
            }
            foldersView.setVisibility(View.VISIBLE);
            foldersView.setAnimation(animation);
            foldersView.startAnimation(animation);
        } else {
            foldersView.setVisibility(View.GONE);
        }
		//Device.setKeyboard(activity,searchText, true);
		//view.requestFocus();
	}

