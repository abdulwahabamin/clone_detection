	@Override
	public void onFinishBuildingLibrary(AsyncBuildLibraryTask task) {
        task.mBuildLibraryProgressUpdate.remove(0);
		Intent intent = new Intent(mContext, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);

	}

