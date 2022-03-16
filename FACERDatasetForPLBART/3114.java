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
		}

		return false;
	}

