	private AlertDialog buildInfoDialog(final int pos) {
		String infotext = getString(mInfoText[pos], mApplicationStrings[pos]);
		String infolaunch = getString(R.string.oi_distribution_info_launch, mApplicationStrings[pos]);
		
		// Trick for Android 2.3:
		// To achieve the visual trick of extending the button over the whole width,
		// we first set a positive button, and then set its visibility to GONE in 
		// onPrepareDialog().
		
		return new AlertDialog.Builder(this)
			.setIcon(android.R.drawable.ic_dialog_info)
			.setTitle(R.string.oi_distribution_info_instructions)
			.setMessage(infotext)
			.setPositiveButton("", null)
			.setNegativeButton(infolaunch,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// click Ok
							launchApplication(pos);
						}
					})
			.create();
	}

