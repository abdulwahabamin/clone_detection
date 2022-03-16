	/**
	 * Builds the "Apply To" dialog. Does not call the show() method, so you 
	 * should do this manually when calling this method.
	 * 
	 * @return A fully built AlertDialog reference.
	 */
	public AlertDialog buildApplyToDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Set the dialog title.
        builder.setTitle(R.string.apply_to);
        builder.setCancelable(false);
        builder.setItems(R.array.apply_equalizer_to_array, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				if (which==0) {
					setEQValuesForSong(mApp.getService().getCurrentSong().getId());
					Toast.makeText(mContext, R.string.eq_applied_to_current_song, Toast.LENGTH_SHORT).show();
					
					//Finish this activity.
                    finish();
					
				} else if (which==1) {	
					AsyncApplyEQToAllSongsTask task = new AsyncApplyEQToAllSongsTask(mContext, mFragment);
					task.execute();
					dialog.dismiss();

                    //Finish this activity.
                    finish();

				} else if (which==2) {
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					EQArtistsListDialog artistDialog = new EQArtistsListDialog();
					artistDialog.show(ft, "eqArtistsListDialog");
					
					dialog.dismiss();

				} else if (which==3) {	
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					EQAlbumsListDialog albumsDialog = new EQAlbumsListDialog();
					albumsDialog.show(ft, "eqAlbumsListDialog");
					
					dialog.dismiss();

				} else if (which==4) {
					FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
					EQGenresListDialog genresDialog = new EQGenresListDialog();
					genresDialog.show(ft, "eqGenresListDialog");
					
					dialog.dismiss();
					
				}
				
			}
        	
        });

        return builder.create(); 
	}

