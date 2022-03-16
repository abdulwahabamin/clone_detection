    @Override
    protected void onProgressUpdate(Void... v) {
		//Update the progress on the progress dialog.
		progress = progress + progressIncrement;
		pd.setProgress(progress);
		pd.setMessage(mContext.getResources().getString(R.string.applying_to) + " " + songTitle);
    	
    }

