	private void launchMainActivity() {
		Intent intent = new Intent(mContext, MainActivity.class);
		int startupScreen = sharedPreferences.getInt("STARTUP_SCREEN", 0);
		
		switch (startupScreen) {
		case 0:
			intent.putExtra("TARGET_FRAGMENT", "ARTISTS");
			break;
		case 1:
			intent.putExtra("TARGET_FRAGMENT", "ALBUM_ARTISTS");
			break;
		case 2:
			intent.putExtra("TARGET_FRAGMENT", "ALBUMS");
			break;
		case 3:
			intent.putExtra("TARGET_FRAGMENT", "SONGS");
			break;
		case 4:
			intent.putExtra("TARGET_FRAGMENT", "PLAYLISTS");
			break;
		case 5:
			intent.putExtra("TARGET_FRAGMENT", "GENRES");
			break;
		case 6:
			intent.putExtra("TARGET_FRAGMENT", "FOLDERS");
			break;
		}
		
		startActivity(intent);
		getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		getActivity().finish();
		
	}

