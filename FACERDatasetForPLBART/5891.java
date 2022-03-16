	public FileNameDialog(Context context, DialogInterface.OnClickListener listener)
	{
		super(context);
		edittext = new EditText(context);
		edittext.setSingleLine();
		edittext.setHint(R.string.name);
		setView(edittext);
		setButton(
			DialogInterface.BUTTON_POSITIVE,
			context.getText(android.R.string.ok),
			listener
		);
	}

