    /**
     * Asks the user to install the GMusic app.
     */
	private void promptUserInstallGooglePlayMusic() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		AlertDialog dialog;
		builder.setTitle(R.string.google_play_music_no_asterisk);
		builder.setMessage(R.string.prompt_user_install_google_play_music);
		builder.setPositiveButton(R.string.yes, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("market://details?id=com.google.android.music"));
				startActivity(intent);

			}
			
		});
		
		builder.setNegativeButton(R.string.no, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				mApp.getSharedPreferences().edit().putBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false).commit();
				Toast.makeText(mContext, R.string.google_play_music_disabled, Toast.LENGTH_LONG).show();
				dialog.dismiss();
				
			}
			
		});
		
		dialog = builder.create();
		dialog.show();
	}

