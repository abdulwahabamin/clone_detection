		@Override
		public void onPostExecute(String result) {
			super.onPostExecute(result);
			
			//Dismiss the progress dialog.
			pd.dismiss();
			mActivity.finish();
			Toast.makeText(mContext, R.string.done_updating_blacklists, Toast.LENGTH_LONG).show();
		}

