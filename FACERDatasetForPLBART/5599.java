	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		if (id >= DIALOG_INFO && id < DIALOG_GET_FROM_MARKET) {
			dialog.findViewById(android.R.id.button1).setVisibility(View.GONE);
		} else if (id >= DIALOG_GET_FROM_MARKET && id < DIALOG_DISTRIBUTION_START){
			DownloadAppDialog.onPrepareDialog(this, dialog);
		}
		
	}

