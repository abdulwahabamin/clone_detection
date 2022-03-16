	@SuppressWarnings("unchecked")
	public void onDialogPositiveClick(DialogFragment dialog) {
		selectedPaths = mAdapter.getCurrentPaths();
		ASyncDeleteFiles delete = new ASyncDeleteFiles(new ProgressDialog(this));
		delete.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, selectedPaths);
		for (int i =0; i < selectedPaths.size(); i++) {
		mAdapter.remove(selectedPaths.get(i));
		}
		mAdapter.notifyDataSetChanged();
		selectedPaths.clear();
		mode.finish(); // Action picked, so close the CAB
	}

