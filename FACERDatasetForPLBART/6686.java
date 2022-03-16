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

        case DIALOG_FILTER:
			inflater = LayoutInflater.from(this);
			view = inflater.inflate(R.layout.dialog_new_folder, null);
			((TextView)view.findViewById(R.id.foldernametext)).setText(R.string.extension);
			final EditText et3 = (EditText) view
					.findViewById(R.id.foldername);
			et3.setText("");
			return new AlertDialog.Builder(this)
            	.setIcon(android.R.drawable.ic_dialog_alert)
            	.setTitle(R.string.menu_filter).setView(view).setPositiveButton(
					android.R.string.ok, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							mFilterFiletype = et3.getText().toString().trim();
							refreshList();
						}
						
					}).setNegativeButton(android.R.string.cancel, new OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// Cancel should not do anything.
						}
						
					}).create();
			

        case DIALOG_DETAILS:
        	inflater = LayoutInflater.from(this);
        	view =  inflater.inflate(R.layout.dialog_details, null);
        	        	
        	return new AlertDialog.Builder(this).setTitle(mContextText).
        			setIcon(mContextIcon).setView(view).create();
        	
        case DIALOG_BOOKMARKS:
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);

        	final Cursor bookmarksCursor = getBookmarks();
        	
        	builder.setTitle(R.string.bookmarks);
        	
        	builder.setCursor(bookmarksCursor, new DialogInterface.OnClickListener() {
	        	    public void onClick(DialogInterface dialog, int item) {
	        	    	if (bookmarksCursor.moveToPosition(item)) {
	        	    		String path = bookmarksCursor.getString(
		        	    			bookmarksCursor.getColumnIndex(BookmarksProvider.PATH));
		        	    	File file = new File(path);
		        	    	if (file != null) {
			        	    	if (file.isDirectory()) {
				        	    	mStepsBack++;
			        	    	}
			        	    	browseTo(file);
		        	    	}
	        	    	} else{
	        	    		Toast.makeText(FileManagerActivity.this, R.string.bookmark_not_found,
	        	    				Toast.LENGTH_SHORT).show();
	        	    	}
	        	    }
	        	}, BookmarksProvider.NAME);
        	
        	return builder.create();

        case DIALOG_COMPRESSING:
            inflater = LayoutInflater.from(this);
            view = inflater.inflate(R.layout.dialog_new_folder, null);
            final EditText editText = (EditText) view.findViewById(R.id.foldername);
            return new AlertDialog.Builder(this)
                    .setTitle(R.string.menu_compress).setView(view).setPositiveButton(
                            android.R.string.ok, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (new File(mContextFile.getParent()+File.separator+editText.getText().toString()).exists()){
                                mDialogArgument = editText.getText().toString();
                                showDialog(DIALOG_WARNING_EXISTS);
                            } else {
                                new CompressManager(FileManagerActivity.this).compress(mContextFile, editText.getText().toString());
                            }
                        }
                    }).setNegativeButton(android.R.string.cancel, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel should not do anything.
                        }
                    }).create();

        case DIALOG_MULTI_COMPRESS_ZIP:
            inflater = LayoutInflater.from(this);
            view = inflater.inflate(R.layout.dialog_new_folder, null);
            final EditText editText1 = (EditText) view.findViewById(R.id.foldername);
            return new AlertDialog.Builder(this)
                    .setTitle(R.string.menu_compress).setView(view).setPositiveButton(
                            android.R.string.ok, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (new File(currentDirectory+File.separator+editText1.getText().toString()).exists()){
                                mDialogArgument = editText1.getText().toString();
                                mDialogExistsAction = DIALOG_EXISTS_ACTION_MULTI_COMPRESS_ZIP;
                                showDialog(DIALOG_WARNING_EXISTS);
                            } else {
                                compressMultiFile(editText1.getText().toString());
                            }
                        }
                    }).setNegativeButton(android.R.string.cancel, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel should not do anything.
                        }
                    }).create();
        
        case DIALOG_WARNING_EXISTS:
            return new AlertDialog.Builder(this).setTitle(getString(R.string.warning_overwrite, mDialogArgument))
                    .setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(
                            android.R.string.ok, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mDialogExistsAction.equals(DIALOG_EXISTS_ACTION_MULTI_COMPRESS_ZIP)){
                                compressMultiFile(mDialogArgument);
                            } else if (mDialogExistsAction.equals(DIALOG_EXISTS_ACTION_RENAME)){
                                File newFile = FileUtils.getFile(currentDirectory, mNewFileName);
                                rename(FileUtils.getFile(currentDirectory, mOldFileName), newFile);
                            } else {
                                new File(mContextFile.getParent()+File.separator+mDialogArgument).delete();
                                new CompressManager(FileManagerActivity.this).compress(mContextFile, mDialogArgument);
                            }
                            mDialogExistsAction = "";
                        }
                    }).setNegativeButton(android.R.string.cancel, new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mDialogExistsAction.equals(DIALOG_EXISTS_ACTION_RENAME)){
                                mContextText = mOldFileName;
                                showDialog(DIALOG_RENAME);
                            } else if (mDialogExistsAction.equals(DIALOG_EXISTS_ACTION_MULTI_COMPRESS_ZIP)){
                                showDialog(DIALOG_MULTI_COMPRESS_ZIP);
                            } else {
                                showDialog(DIALOG_COMPRESSING);
                            }
                            mDialogExistsAction = "";
                        }
                    }).create();

            case DIALOG_CHANGE_FILE_EXTENSION:
                return new AlertDialog.Builder(this).setTitle(getString(R.string.change_file_extension))
                        .setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(
                                android.R.string.ok, new OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                File newFile = FileUtils.getFile(currentDirectory, mNewFileName);
                                if (newFile.exists()){
                                    mDialogExistsAction = DIALOG_EXISTS_ACTION_RENAME;
                                    showDialog(DIALOG_WARNING_EXISTS);
                                } else {
                                    rename(FileUtils.getFile(currentDirectory, mOldFileName), newFile);
                                }
                            }
                        }).setNegativeButton(android.R.string.cancel, new OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mContextText = mOldFileName;
                                showDialog(DIALOG_RENAME);
                            }
                        }).create();
		}
		return super.onCreateDialog(id);
			
	}

