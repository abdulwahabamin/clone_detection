		@Override
		public void onPostExecute(String result) {
			super.onPostExecute(result);
			//Launch the music library editor activity.
			Intent intent = new Intent(mContext, MusicLibraryEditorActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("LIBRARY_NAME", mLibraryName);
			bundle.putString("LIBRARY_ICON", mLibraryColorCode);
			bundle.putSerializable("SONG_IDS_HASH_SET", songIdsHashSet);
			intent.putExtras(bundle);
			intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(intent);
			
		}

