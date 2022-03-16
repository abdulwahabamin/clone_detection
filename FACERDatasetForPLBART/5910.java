	public void pasteFiles()
	{
		if(selected_files.size() > 0)
		{
			paste_progress_dialog = ProgressDialog.show(
				this,
				getText(android.R.string.paste),
				getText(R.string.in_progress),
				true,
				true,
				this
			);
			copy_or_move_task = new CopyOrMoveTask()
			{
				public void onCancelled()
				{
					paste_progress_dialog.dismiss();
					selected_files.clear();
					updateFileList();
				}

				public void onPostExecute(Boolean result)
				{
					paste_progress_dialog.dismiss();
					if(result)
						showToast(android.R.string.ok);
					else
						showToast(R.string.cannot_copy_or_move);

					selected_files.clear();
					updateFileList();
				}
			};
			copy_or_move_task.files_to_copy = selected_files;
			copy_or_move_task.destination_dir = current_dir;
			copy_or_move_task.move_files = action_cut;
			copy_or_move_task.copy_prefix = getString(android.R.string.copy);
			copy_or_move_task.execute();
		}
		else showToast(R.string.nothing_selected);
	}

