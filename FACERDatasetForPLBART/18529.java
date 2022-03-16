	public void showNewPlaylistDialog() {
		View dialogView = getActivity().getLayoutInflater().inflate(R.layout.add_new_playlist_dialog_layout, null);
		final EditText newPlaylistEditText = (EditText) dialogView.findViewById(R.id.new_playlist_name_text_field);
		newPlaylistEditText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		newPlaylistEditText.setPaintFlags(newPlaylistEditText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.new_playlist);
		builder.setView(dialogView);
		builder.setPositiveButton(R.string.ok, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Retrieve the name of the new playlist.
				String playlistName = newPlaylistEditText.getText().toString();
				AsyncCreateNewPlaylistTask task = new AsyncCreateNewPlaylistTask(mContext, 
																				 playlistName, 
																				 ARTIST, 
																				 ALBUM, 
																				 SONG, 
																				 GENRE, 
																				 ALBUM_ARTIST,
																				 ADD_TYPE);
				task.execute();
				dialog.dismiss();
				
			}
			
		});
		
		builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
			
		});
		
		builder.create().show();
	}

