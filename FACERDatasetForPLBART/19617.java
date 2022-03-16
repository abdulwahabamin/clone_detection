		@Override
		public void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			pd.dismiss();
			Toast.makeText(mContext, R.string.blacklist_reset, Toast.LENGTH_SHORT).show();
		}

