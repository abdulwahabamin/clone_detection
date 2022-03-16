    public void onPreExecute() {
    	super.onPreExecute();
    	
    	pd = new ProgressDialog(mActivity);
    	pd.setTitle(R.string.downloading_album_art);
    	pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    	pd.setCancelable(false);
    	pd.setCanceledOnTouchOutside(false);
    	pd.setMessage(mContext.getResources().getString(R.string.scanning_for_missing_art));
    	pd.setButton(DialogInterface.BUTTON_NEGATIVE, 
    				 mContext.getResources().getString(R.string.cancel),
    				 new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							task.cancel(true);
							
						}
    		
    	});
    	
    	pd.show();	
    	
    }

