	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = super.onCreateDialog(id);
		
		if (dialog != null) {
			return dialog;
		}
		
		if (id >= DIALOG_INFO && id < DIALOG_GET_FROM_MARKET) {
			dialog = buildInfoDialog(id - DIALOG_INFO);
		} else if (id >= DIALOG_GET_FROM_MARKET && id < DIALOG_DISTRIBUTION_START){
			dialog = buildGetFromMarketDialog(id - DIALOG_GET_FROM_MARKET);
		}
		/*if (dialog == null) {
			dialog = super.onCreateDialog(id);
		}*/
		return dialog;
	}

