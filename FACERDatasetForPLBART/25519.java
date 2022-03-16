	private void showSongSettingsDialog(){
		new AlertDialog.Builder(this).setTitle("Song Details")
				.setItems(new String[]{"enabled"}, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
	}

