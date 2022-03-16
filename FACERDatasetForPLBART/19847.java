	/**
	 * Ask the user to set up GMusic.
	 */
	private void promptUserSetUpGooglePlayMusic() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		AlertDialog dialog;
		builder.setTitle(R.string.tip);
		builder.setMessage(R.string.prompt_user_set_up_google_play_music);
		builder.setPositiveButton(R.string.let_me_check, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
				startActivity(intent);
				dialog.dismiss();
	
			}
			
		});
		
		builder.setNeutralButton(R.string.sync_manually, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
			
		});
		
		builder.setNegativeButton(R.string.set_up_already, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
			
		});
		
		dialog = builder.create();
		dialog.show();
	}

