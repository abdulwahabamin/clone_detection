    protected void onPreExecute() {
		pd = new ProgressDialog(mContext);
		pd.setIndeterminate(false);
		pd.setMax(max);
		pd.setCancelable(false);
		pd.setTitle(mContext.getResources().getString(R.string.applying_equalizer_to) + " " + titlePlaylist);
		pd.show();
    	
    }

