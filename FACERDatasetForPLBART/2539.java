	/**
	 * Paste option was selected
	 * @param mode The action mode in use
	 * @return If the action was successful
	 */

	@SuppressWarnings("unchecked")
	public boolean contextAcceptPaste(ActionMode mode) {
		
		ASyncCopyFiles copy = new ASyncCopyFiles(new ProgressDialog(d), d.getPath());
		copy.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, d.getFilesMoving());
		
		
		for (int i = 0; i < d.getFilesMoving().size(); i++) {
			d.getCurrentFileList().add(d.getPath() + "/" + d.getFilesMoving().get(i).getName());
		}
		d.getSelectedPaths().clear();
		d.getmAdapter().notifyDataSetChanged();
		mode.finish(); // Action picked, so close the CAB
		return true;
	}

