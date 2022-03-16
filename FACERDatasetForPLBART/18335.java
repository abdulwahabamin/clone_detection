		@Override
		public void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(mContext);
			pd.setTitle(R.string.blacklist_manager);
			pd.setIndeterminate(true);
			pd.setMessage(mContext.getResources().getString(R.string.fetching_blacklists));
			pd.setCancelable(false);
			pd.setCanceledOnTouchOutside(false);
			pd.show();
			
		}

