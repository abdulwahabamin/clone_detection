	/**
	 * Displays the "Resuming from xx:xx" toast.
	 */
	public void displayAudiobookToast(long resumePlaybackPosition) {
		try {
			String resumingFrom = mContext.getResources().getString(R.string.resuming_from) 
								+ " " + mApp.convertMillisToMinsSecs(resumePlaybackPosition) + ".";
			
			Toast.makeText(mContext, resumingFrom, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

