	/**
	 * Determines whether delete was confirmed or cancelled
	 */
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		if (arg1 == DialogInterface.BUTTON_POSITIVE) {
			onDialogPositiveClick((DialogFragment) arg0);
		} else {
			onDialogNegativeClick((DialogFragment) arg0);
		}

	}

