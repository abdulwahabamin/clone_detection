	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		String[] blacklistManagerChoices = { getActivity().getResources().getString(R.string.manage_blacklisted_artists),
											 getActivity().getResources().getString(R.string.manage_blacklisted_albums), 
											 getActivity().getResources().getString(R.string.manage_blacklisted_songs), 
											 getActivity().getResources().getString(R.string.manage_blacklisted_playlists) };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.blacklist_manager);
        builder.setItems(blacklistManagerChoices, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Bundle bundle = new Bundle();
				
				if (which==0) {
					bundle.putString("MANAGER_TYPE", "ARTISTS");
				} else if (which==1) {
					bundle.putString("MANAGER_TYPE", "ALBUMS");
				} else if (which==2) {
					bundle.putString("MANAGER_TYPE", "SONGS");
				} else if (which==3) {
					bundle.putString("MANAGER_TYPE", "PLAYLISTS");
				}
				
				dialog.dismiss();
				Intent intent = new Intent(getActivity(), BlacklistManagerActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
				
			}
        	
        });

        return builder.create();
    }

