 	/**
 	 * 
 	 */
 	private void refreshDirectoryPanel() {
 		if (isDirectoryInputVisible()) {
 			// Set directory path
 			String path = currentDirectory.getAbsolutePath();
 			mEditDirectory.setText(path);
 			
 			// Set selection to last position so user can continue to type:
 			mEditDirectory.setSelection(path.length());
 		} else {
 			setDirectoryButtons();
 		}
 	} 

