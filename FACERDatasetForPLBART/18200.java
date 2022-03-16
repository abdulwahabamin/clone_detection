	@Override
	protected void onProgressUpdate(String... progressParams) {
		super.onProgressUpdate(progressParams);

        if (progressParams.length > 0 && progressParams[0].equals("MEDIASTORE_TRANSFER_COMPLETE")) {
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
                    mBuildLibraryProgressUpdate.get(i).onProgressUpdate(this, mCurrentTask, mOverallProgress,
                            1000000, true);

            return;
        }

		if (mBuildLibraryProgressUpdate!=null)
            for (int i=0; i < mBuildLibraryProgressUpdate.size(); i++)
                if (mBuildLibraryProgressUpdate.get(i)!=null)
			        mBuildLibraryProgressUpdate.get(i).onProgressUpdate(this, mCurrentTask, mOverallProgress, 1000000, false);
		
	}

