     /**
      * Browse to some location by clicking on a list item.
      * @param aDirectory
      */
     private void browseTo(final File aDirectory){ 
          // setTitle(aDirectory.getAbsolutePath());
          
          if (aDirectory.isDirectory()){
        	  if (aDirectory.equals(currentDirectory)) {
        		  // Switch from button to directory input
        		  showDirectoryInput(true);
        	  } else {
        		   mPreviousDirectory = currentDirectory;
	               currentDirectory = aDirectory;
	               refreshList();
//	               selectInList(previousDirectory);
	//               refreshDirectoryPanel();
        	  }
          }else{ 
        	  if (mState == STATE_BROWSE || mState == STATE_PICK_DIRECTORY) {
	              // Lets start an intent to View the file, that was clicked... 
	        	  openFile(aDirectory); 
        	  } else if (mState == STATE_PICK_FILE) {
        		  // Pick the file
        		  mEditFilename.setText(aDirectory.getName());
        	  }
          } 
     }

