     private void showDirectoryContents(DirectoryContents contents) {
    	 mDirectoryScanner = null;
    	 
    	 mListSdCard = contents.listSdCard;
    	 mListDir = contents.listDir;
    	 mListFile = contents.listFile;
    	 mNoMedia = contents.noMedia;
    	 
    	 if(!mRestored){
           directoryEntries.ensureCapacity(mListSdCard.size() + mListDir.size() + mListFile.size());

           addAllElements(directoryEntries, mListSdCard);
           addAllElements(directoryEntries, mListDir);
           addAllElements(directoryEntries, mListFile);

         mDirectoryEntries = directoryEntries.toArray(new IconifiedText[0]);
       }
       else {
         directoryEntries.clear();
         directoryEntries.ensureCapacity(mDirectoryEntries.length);
         for(int i = 0; i < mDirectoryEntries.length; i++){
           directoryEntries.add(mDirectoryEntries[i]);	
         }

         mRestored = false;
       }

         IconifiedTextListAdapter itla = new IconifiedTextListAdapter(this); 
         itla.setListItems(directoryEntries, getListView().hasTextFilter(), currentDirectory, mMimeTypes);          
         setListAdapter(itla); 
	     getListView().setTextFilterEnabled(true);
	     
	     ThumbnailLoader mThumbnailLoader = ((IconifiedTextListAdapter) getListAdapter()).getThumbnailLoader();
	     
	     if(fileDeleted){
	    	 getListView().setSelection(positionAtDelete);
	     }

         selectInList(mPreviousDirectory);
         refreshDirectoryPanel();
         setProgressBarIndeterminateVisibility(false);

    	 mProgressBar.setVisibility(View.GONE);
    	 mEmptyText.setVisibility(View.VISIBLE);
    	 
    	 toggleCheckBoxVisibility(mState == STATE_MULTI_SELECT);
     }

