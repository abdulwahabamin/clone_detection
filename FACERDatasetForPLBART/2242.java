	@Override
	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case DIALOG_NEW_FOLDER:
			LayoutInflater inflater = LayoutInflater.from(this);
			View view = inflater.inflate(R.layout.dialog_new_folder, null);
			final EditText et = (EditText) view
					.findViewById(R.id.foldername);
			et.setText("");
			return new AlertDialog.Builder(this)
            	.setIcon(android.R.drawable.ic_dialog_alert)
            	.setTitle(R.string.create_new_folder).setView(view).setPositiveButton(
					android.R.string.ok, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							createNewFolder(et.getText().toString());
						}
						
					}).setNegativeButton(android.R.string.cancel, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// Cancel should not do anything.
						}
						
					}).create();
		

		case DIALOG_DELETE:
			return new AlertDialog.Builder(this).setTitle(getString(R.string.really_delete, mContextText))
            	.setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(
					android.R.string.ok, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							deleteFileOrFolder(mContextFile);
						}
						
					}).setNegativeButton(android.R.string.cancel, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// Cancel should not do anything.
						}
						
					}).create();

		case DIALOG_RENAME:
			inflater = LayoutInflater.from(this);
			view = inflater.inflate(R.layout.dialog_new_folder, null);
			final EditText et2 = (EditText) view
				.findViewById(R.id.foldername);
			return new AlertDialog.Builder(this)
            	.setTitle(R.string.menu_rename).setView(view).setPositiveButton(
					android.R.string.ok, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							
							renameFileOrFolder(mContextFile, et2.getText().toString());
						}
						
					}).setNegativeButton(android.R.string.cancel, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// Cancel should not do anything.
						}
						
					}).create();
			
        case DIALOG_MULTI_DELETE:
            String contentText = null;
            int count = 0;
            for (IconifiedText it : mDirectoryEntries) {
                if (!it.isSelected()) {
                    continue;
                }

                contentText = it.getText();
                count++;
            }
            String string;
            if (count == 1) {
                 string = getString(R.string.really_delete, contentText);
            } else {
                string = getString(R.string.really_delete_multiselect, count);
            }
            return new AlertDialog.Builder(this).setTitle(string)
                .setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(
                    android.R.string.ok, new OnClickListener() {
                        
                        public void onClick(DialogInterface dialog, int which) {
                            deleteMultiFile();
    
                            Intent intent = getIntent();
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                        
                    }).setNegativeButton(android.R.string.cancel, new OnClickListener() {
                        
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel should not do anything.
                        }
                    
                    }).create();

		}
		return super.onCreateDialog(id);
		
	}

