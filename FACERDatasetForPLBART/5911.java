	public void deleteFiles()
	{
		getSelectedFiles();
		if(selected_files.size() > 0)
		{
			delete_progress_dialog = ProgressDialog.show(
				this,
				getText(R.string.delete),
				getText(R.string.in_progress),
				true,
				true,
				this
			);
			delete_task = new DeleteTask(selected_files)
			{
				public void onCancelled()
				{
					delete_progress_dialog.dismiss();
					selected_files.clear();
					updateFileList();
				}

				public void onPostExecute(Boolean result)
				{
					delete_progress_dialog.dismiss();
					if(result)
						showToast(android.R.string.ok);
					else
						showToast(R.string.cannot_delete);

					selected_files.clear();
					updateFileList();
				}
			};
			delete_task.execute();
		}
		else showToast(R.string.nothing_selected);
	}

