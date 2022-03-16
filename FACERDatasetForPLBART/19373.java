		@Override
		public void onPostExecute(Cursor cursor) {
			super.onPostExecute(cursor);
			if (cursor!=null) {
                if (!mIsUpdating)
                    getBuildCursorListener().onServiceCursorReady(cursor, mCurrentSongIndex, mPlayAll);
                else
                    getBuildCursorListener().onServiceCursorUpdated(cursor);

            } else {
                getBuildCursorListener().onServiceCursorFailed("Playback cursor null.");
            }

		}

