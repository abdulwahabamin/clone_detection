		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			pd.setProgress(i);
			String message = mContext.getResources().getString(R.string.saving_song_info_for) + " " + titlesList.get(i) + ".";
			pd.setMessage(message);
			
		}

