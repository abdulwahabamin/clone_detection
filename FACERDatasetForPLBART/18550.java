	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		mApp = (Common) getActivity().getApplicationContext();
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//Get the operation that needs to be performed (edit vs. delete).
		operation = getArguments().getString("OPERATION");
		if (operation.equals("EDIT")) {
			builder.setTitle(R.string.edit_music_library);
		} else {
			builder.setTitle(R.string.delete_music_library);
		}
		
		//Get a cursor with a list of all the music libraries on the device.
		cursor = mApp.getDBAccessHelper().getAllUniqueUserLibraries(getActivity().getApplicationContext());
		
		if (cursor.getCount()==0) {
			getActivity().finish();
			Toast.makeText(getActivity(), R.string.no_music_libraries_found, Toast.LENGTH_SHORT).show();
		}
		
		builder.setAdapter(new EditDeleteMusicLibraryAdapter(getActivity(), cursor), new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Get the name of the library that has just been clicked. Also get its lable color code.
				cursor.moveToPosition(which);
				String libraryName = cursor.getString(cursor.getColumnIndex(DBAccessHelper.LIBRARY_NAME));
				String libraryColorCode = cursor.getString(cursor.getColumnIndex(DBAccessHelper.LIBRARY_TAG));
				
				if (operation.equals("DELETE")) {
					//Loop through the DB and look for entries that have the specified name and color code. Delete those entries.
					mApp.getDBAccessHelper().deleteLibrary(libraryName, libraryColorCode);
					
					//Display a toast message.
					String toastMessage = getActivity().getResources().getString(R.string.deleted) + " " + libraryName;
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_LONG).show();
					
				} else {
					AsyncGetLibrarySongIdsTask task = new AsyncGetLibrarySongIdsTask(getActivity().getApplicationContext(),
																					 libraryName,
																					 libraryColorCode);
					task.execute();
					
				}
				
				dialog.dismiss();
			}
			
		});
        
        return builder.create();
    }

