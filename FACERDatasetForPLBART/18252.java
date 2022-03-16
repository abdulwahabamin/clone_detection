    protected void onPreExecute() {
    	//Create a String template for the dialog's message body.
    	String message = mContext.getResources().getString(R.string.scanning_subfolders_message) + " " + mFolderName;
    	
		pd = new ProgressDialog(mContext);
		pd.setCancelable(false);
		pd.setIndeterminate(false);
		pd.setTitle(R.string.scanning_subfolders);
		pd.setMessage(message);
		pd.show();
    	
    }

