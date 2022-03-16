	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		
		switch (id) {
		case DIALOG_NEW_FOLDER:
			EditText et = (EditText) dialog.findViewById(R.id.foldername);
			et.setText("");
			break;

		case DIALOG_DELETE:
			((AlertDialog) dialog).setTitle(getString(R.string.really_delete, mContextText));
			break;
			
		case DIALOG_RENAME:
			et = (EditText) dialog.findViewById(R.id.foldername);
			et.setText(mContextText);
			TextView tv = (TextView) dialog.findViewById(R.id.foldernametext);
			if (mContextFile.isDirectory()) {
				tv.setText(R.string.file_name);
			} else {
				tv.setText(R.string.file_name);
			}
			((AlertDialog) dialog).setIcon(mContextIcon);
			break;

		case DIALOG_ABOUT:
			break;
		}
	}

