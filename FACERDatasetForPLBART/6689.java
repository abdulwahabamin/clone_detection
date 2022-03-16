	/**
	 * @since 2011-09-30
	 */
	private void showWarningDialog() {
		LayoutInflater li = LayoutInflater.from(this);
		View warningView = li.inflate(R.layout.dialog_warning, null);
		final CheckBox showWarningAgain = (CheckBox)warningView.findViewById(R.id.showagaincheckbox);
		
		showWarningAgain.setChecked(PreferenceActivity.getShowAllWarning(FileManagerActivity.this));
		
		new AlertDialog.Builder(this).setView(warningView).setTitle(getString(R.string.title_warning_some_may_not_work))
				.setMessage(getString(R.string.warning_some_may_not_work, mContextText))
		    	.setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(
					android.R.string.ok, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							PreferenceActivity.setShowAllWarning(FileManagerActivity.this, showWarningAgain.isChecked());

							showMoreCommandsDialog();
						}
						
					}).create()
				.show();
	}

