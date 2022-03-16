    @Override
    protected void onProgressUpdate(Void... v) {

		//Update the progress on the progress dialog.
		pd.setMessage(mContext.getResources().getString(R.string.scanning_for_files) + " " + mFolderName);
    	 
    }

