		@Override
		public void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(mSettingsActivity);
			pd.setTitle(R.string.reset_blacklist);
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.setMessage(getResources().getString(R.string.resetting_blacklist));
			pd.show();
			
		}

