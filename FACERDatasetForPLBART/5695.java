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
            et.setSelection(0, mContextText.lastIndexOf(".") == -1 ? mContextText.length() : mContextText.lastIndexOf("."));
			((AlertDialog) dialog).setIcon(mContextIcon);
			break;

		case DIALOG_MULTI_DELETE:
            break;
            
		case DIALOG_DETAILS:
			final TextView type = ((TextView)dialog.findViewById(R.id.details_type_value));
        	type.setText((mContextFile.isDirectory() ? R.string.details_type_folder :
        				(mContextFile.isFile() ? R.string.details_type_file :
        					R.string.details_type_other)));
        	
        	final TextView size = ((TextView)dialog.findViewById(R.id.details_size_value));
        	size.setText(FileUtils.formatSize(this, mContextFile.length()));
        	
        	// Creates a background thread that obtains the size of a directory and updates
        	// the TextView accordingly.
        	if(mContextFile.isDirectory()){
        		final AsyncTask folderSizeTask = new AsyncTask<File, Long, Long>(){
        			
        			protected long totalSize = 0L;
        			
    				@Override
    				protected Long doInBackground(File... file) {
    					sizeOf(file[0]);
    					return totalSize;
    				}
            		
    				@Override
    				protected void onProgressUpdate(Long... updatedSize){
    					size.setText(FileUtils.formatSize(size.getContext(), updatedSize[0]));
    				}
    				
    				@Override
    				protected void onPostExecute(Long result){
    					size.setText(FileUtils.formatSize(size.getContext(), result));
    				}
    				
    				private void sizeOf(File file){
    					if(file.isFile()){
    						totalSize += file.length();
    						publishProgress(totalSize);
    					} else {
    						File[] files = file.listFiles();
    						
    						if(files != null && files.length != 0){
        						for(File subFile : files){
        							sizeOf(subFile);
        						}
    						}
    					}
    				}
            	}.execute(mContextFile);
            	
            	((AlertDialog) dialog).setOnCancelListener(new OnCancelListener(){
    				@Override
    				public void onCancel(DialogInterface dialog) {
    					folderSizeTask.cancel(true);
    				}
            	});
        	}
        	
        	String perms = (mContextFile.canRead() ? "R" : "-") +
        			(mContextFile.canWrite() ? "W" : "-") +
        			(FileUtils.canExecute(mContextFile) ? "X" : "-");
        	
        	final TextView permissions = ((TextView)dialog.findViewById(R.id.details_permissions_value));
        	permissions.setText(perms);
        	
        	final TextView hidden = ((TextView)dialog.findViewById(R.id.details_hidden_value));
        	hidden.setText(mContextFile.isHidden() ? R.string.details_yes : R.string.details_no);
        	
        	final TextView lastmodified = ((TextView)dialog.findViewById(R.id.details_lastmodified_value));
        	lastmodified.setText(FileUtils.formatDate(this, mContextFile.lastModified()));
        	((AlertDialog) dialog).setIcon(mContextIcon);
        	((AlertDialog) dialog).setTitle(mContextText);
			break;

        case DIALOG_COMPRESSING:
            TextView textView = (TextView) dialog.findViewById(R.id.foldernametext);
            textView.setText(R.string.compress_into_archive);
            final EditText editText = (EditText) dialog.findViewById(R.id.foldername);
            String archiveName = "";
            if (mContextFile.isDirectory()){
                archiveName = mContextFile.getName()+".zip";
            } else {
                String extension = FileUtils.getExtension(mContextFile.getName());
                archiveName = mContextFile.getName().replaceAll(extension, "")+".zip";
            }
            editText.setText(archiveName);
            editText.setSelection(0, archiveName.length()-4);
            break;

        case DIALOG_MULTI_COMPRESS_ZIP:
            textView = (TextView) dialog.findViewById(R.id.foldernametext);
            textView.setText(R.string.compress_into_archive);
            final EditText editText1 = (EditText) dialog.findViewById(R.id.foldername);
            archiveName = currentDirectory.getName()+".zip";
            editText1.setText(archiveName);
            editText1.setSelection(0, archiveName.length()-4);
            break;

        case DIALOG_WARNING_EXISTS:
            dialog.setTitle(getString(R.string.warning_overwrite, mDialogArgument));
        }
	}

