	public void onCancel(DialogInterface dialog)
	{
		if(dialog == delete_progress_dialog) delete_task.cancel(true);
		else if(dialog == paste_progress_dialog) copy_or_move_task.cancel(true);
		else if(dialog == search_progress_dialog) search_task.cancel(true);
	}

