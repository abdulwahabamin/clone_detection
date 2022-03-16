    protected void onPreExecute() {
		pd = new ProgressDialog(mFragment.getActivity());
		pd.setCancelable(false);
		pd.setIndeterminate(false);

        if (mShouldMove) {
            pd.setTitle(R.string.move);
            pd.setMessage(mContext.getResources().getString(R.string.moving_file));
        } else {
            pd.setTitle(R.string.copy);
            pd.setMessage(mContext.getResources().getString(R.string.copying_file));
        }

		pd.setButton(DialogInterface.BUTTON_NEUTRAL, mContext.getResources()
															 .getString(R.string.run_in_background), 
															 new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				pd.dismiss();
				
			}
			
		});
		
		pd.show();
    	
    }

