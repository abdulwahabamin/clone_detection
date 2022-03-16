	public Dialog onCreateDialog(int id, Bundle args)
	{
		AlertDialog.Builder dialog_builder;

		switch(id)
		{
			case R.string.file_already_exists:
				dialog_builder = new AlertDialog.Builder(this);
				dialog_builder.setTitle(R.string.file_already_exists);
				dialog_builder.setMessage(R.string.replace_its_content);
				dialog_builder.setPositiveButton(android.R.string.yes, this);
				dialog_builder.setNegativeButton(android.R.string.no, this);
				alert_dialog = dialog_builder.create();
				return alert_dialog;
			default:
				return null;
		}
	}

