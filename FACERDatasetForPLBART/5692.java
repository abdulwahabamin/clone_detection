	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		
		// Remember current selection
        IconifiedTextListAdapter adapter = (IconifiedTextListAdapter) getListAdapter();
        
        if (adapter == null) {
      	  return false;
        }
        
        IconifiedText ic = (IconifiedText) adapter.getItem(menuInfo.position);
		mContextText = ic.getText();
		mContextIcon = ic.getIcon();
		mContextFile = FileUtils.getFile(currentDirectory, ic.getText());
		
		switch (item.getItemId()) {
		case MENU_OPEN:
            openFile(mContextFile); 
			return true;
			
		case MENU_MOVE:
			promptDestinationAndMoveFile();
			return true;
			
		case MENU_COPY:
			promptDestinationAndCopyFile();
			return true;
			
		case MENU_DELETE:
			showDialog(DIALOG_DELETE);
			return true;

		case MENU_RENAME:
			showDialog(DIALOG_RENAME);
			return true;
			
		case MENU_SEND:
			sendFile(mContextFile);
			return true;
		
		case MENU_DETAILS:
			showDialog(DIALOG_DETAILS);
			return true;

        case MENU_COMPRESS:
            showDialog(DIALOG_COMPRESSING);
            return true;

        case MENU_EXTRACT:
            promptDestinationAndExtract();            
            return true;
			
		case MENU_BOOKMARK:
			String path = mContextFile.getAbsolutePath();
			Cursor query = managedQuery(BookmarksProvider.CONTENT_URI,
										new String[]{BookmarksProvider._ID},
										BookmarksProvider.PATH + "=?",
										new String[]{path},
										null);
			if(!query.moveToFirst()){
				ContentValues values = new ContentValues();
				values.put(BookmarksProvider.NAME, mContextFile.getName());
				values.put(BookmarksProvider.PATH, path);
				getContentResolver().insert(BookmarksProvider.CONTENT_URI, values);
				Toast.makeText(this, R.string.bookmark_added, Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, R.string.bookmark_already_exists, Toast.LENGTH_SHORT).show();
			}
			return true;

		case MENU_MORE:
			if (!PreferenceActivity.getShowAllWarning(FileManagerActivity.this)) {
				showMoreCommandsDialog();
				return true;
			}

			showWarningDialog();

			return true;
		}

		return false;
	}

