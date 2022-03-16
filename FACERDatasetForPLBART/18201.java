	@Override
	protected void onPostExecute(Void arg0) {
		//Release the wakelock.
		wakeLock.release();
		mApp.setIsBuildingLibrary(false);
		mApp.setIsScanFinished(true);

        Toast.makeText(mContext, R.string.finished_scanning_album_art, Toast.LENGTH_LONG).show();
		
		if (mBuildLibraryProgressUpdate!=null)
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
			        mBuildLibraryProgressUpdate.get(i).onFinishBuildingLibrary(this);

	}

