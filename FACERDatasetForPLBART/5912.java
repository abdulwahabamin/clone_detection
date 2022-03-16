	public void searchForFiles(String name)
	{
		search_progress_dialog = ProgressDialog.show(
			this,
			getText(R.string.new_search),
			getText(R.string.in_progress),
			true,
			true,
			this
		);
		search_task = new SearchTask(name)
		{
			public void onCancelled()
			{
				search_progress_dialog.dismiss();
				searchResults();
			}

			public void onPostExecute(Boolean result)
			{
				search_progress_dialog.dismiss();
				searchResults();
			}
		};
		search_task.execute(current_dir);
	}

