	@Override
	public void onProgressUpdate(AsyncBuildLibraryTask task, String mCurrentTask,
                                 int overallProgress, int maxProgress,
                                 boolean mediaStoreTransferDone) {
        /**
         * overallProgress refers to the progress that the service's notification
         * progress bar will display. Since this fragment will only show the progress
         * of building the library (and not scanning the album art), we need to
         * multiply the overallProgress by 4 (the building library task only takes
         * up a quarter of the overall progress bar).
         */
		mProgressBar.setProgress(overallProgress*4);

        //This fragment only shows the MediaStore transfer progress.
        if (mediaStoreTransferDone)
            onFinishBuildingLibrary(task);
		
	}

