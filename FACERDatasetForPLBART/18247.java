    protected void onPreExecute() {
    	
    	if (mFirstRun) {
        	pd = new ProgressDialog(mActivity);
    		pd.setCancelable(false);
    		pd.setIndeterminate(true);
    		pd.setTitle(R.string.signing_in);
    		pd.setMessage(mContext.getResources().getString(R.string.contacting_google_play_music));
    		pd.show();
    	}

    }

