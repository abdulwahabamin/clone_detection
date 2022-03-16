	public void run() {
		Log.v(TAG, "Scanning directory " + currentDirectory);
		
		File[] files = currentDirectory.listFiles();

		int fileCount = 0;
		int dirCount = 0;
		int sdCount = 0;
		int totalCount = 0;
		
		if (cancel) {
			Log.v(TAG, "Scan aborted");
			clearData();
			return;
		}
		
		if (files == null) {
			Log.v(TAG, "Returned null - inaccessible directory?");
			totalCount = 0;
		} else {
			totalCount = files.length;
		}
		
		operationStartTime = SystemClock.uptimeMillis();
		
		Log.v(TAG, "Counting files... (total count=" + totalCount + ")");

		int progress = 0;
		
		/** Dir separate for return after sorting*/
 		List<IconifiedText> listDir = new ArrayList<IconifiedText>(totalCount);
		/** Dir separate for sorting */
		List<File> listDirFile = new ArrayList<File>(totalCount);

		/** Files separate for return after sorting*/
 		List<IconifiedText> listFile = new ArrayList<IconifiedText>(totalCount);
		/** Files separate for sorting */
		List<File> listFileFile = new ArrayList<File>(totalCount);

		/** SD card separate for sorting - actually not sorted, so we don't need an ArrayList<File>*/
		List<IconifiedText> listSdCard = new ArrayList<IconifiedText>(3);
		
		boolean noMedia = false;

		// Cache some commonly used icons.
		Drawable sdIcon = context.getResources().getDrawable(R.drawable.ic_launcher_sdcard);
		Drawable folderIcon = context.getResources().getDrawable(R.drawable.ic_launcher_folder);
		Drawable genericFileIcon = context.getResources().getDrawable(R.drawable.icon_file);

		Drawable currentIcon = null; 
		
		boolean displayHiddenFiles = PreferenceActivity.getDisplayHiddenFiles(context);
		
		if (files != null) {
			for (File currentFile : files){ 
				if (cancel) {
					// Abort!
					Log.v(TAG, "Scan aborted while checking files");
					clearData();
					return;
				}

				progress++;
				updateProgress(progress, totalCount);

				//If the user doesn't want to display hidden files and the file is hidden,
				//skip displaying the file
				if (!displayHiddenFiles && currentFile.isHidden()){
					continue;
				}
				 			
				
				if (currentFile.isDirectory()) { 
					if (currentFile.getAbsolutePath().equals(mSdCardPath)) {
						currentIcon = sdIcon;

						listSdCard.add(new IconifiedText( 
								currentFile.getName(), "", currentIcon)); 
					} else {
						if (!mWriteableOnly || currentFile.canWrite()){
							listDirFile.add(currentFile);
						}
					}
				}else{ 
					String fileName = currentFile.getName(); 
					
					// Is this the ".nomedia" file?
					if (!noMedia) {
						if (fileName.equalsIgnoreCase(".nomedia")) {
							// It is!
							noMedia = true;
						}
					}

					String mimetype = mMimeTypes.getMimeType(fileName);

					String filetype = FileUtils.getExtension(fileName);
					boolean ext_allow = filetype.equalsIgnoreCase(mFilterFiletype) || mFilterFiletype == "";
					boolean mime_allow = mFilterMimetype != null && 
							(mimetype.contentEquals(mFilterMimetype) || mFilterMimetype.contentEquals("*/*") ||
									mFilterFiletype == null);
					if (!mDirectoriesOnly && (ext_allow || mime_allow)) {
						listFileFile.add(currentFile);
					}
				} 
			}
		}
		
		Log.v(TAG, "Sorting results...");
		
		//Collections.sort(mListSdCard); 
		int sortBy = PreferenceActivity.getSortBy(context);
		boolean ascending = PreferenceActivity.getAscending(context);
		
		
		Collections.sort(listDirFile, Comparators.getForDirectory(sortBy, ascending)); 
		Collections.sort(listFileFile, Comparators.getForFile(sortBy, ascending)); 
		
		for(File f : listDirFile){
			listDir.add(new IconifiedText( 
					f.getName(), "", folderIcon));
		}
		
		for(File currentFile : listFileFile){
			String mimetype = mMimeTypes.getMimeType(currentFile.getName());
			currentIcon = getDrawableForMimetype(currentFile, mimetype);
			if (currentIcon == null) {
				currentIcon = genericFileIcon;
			} else {
				int width = genericFileIcon.getIntrinsicWidth();
				int height = genericFileIcon.getIntrinsicHeight();
				// Resizing image.
				currentIcon = ImageUtils.resizeDrawable(currentIcon, width, height);

			}

			String size = "";

			try {
				size = (String) formatter_formatFileSize.invoke(null, context, currentFile.length());
			} catch (Exception e) {
				// The file size method is probably null (this is most
				// likely not a Cupcake phone), or something else went wrong.
				// Let's fall back to something primitive, like just the number
				// of KB.
				size = Long.toString(currentFile.length() / 1024);
				size +=" KB";

				// Technically "KB" should come from a string resource,
				// but this is just a Cupcake 1.1 callback, and KB is universal
				// enough.
			}
			
			listFile.add(new IconifiedText( 
					currentFile.getName(), size + " , " + FileUtils.formatDate(
							context, currentFile.lastModified()), currentIcon));
		}

		if (!cancel) {
			Log.v(TAG, "Sending data back to main thread");
			
			DirectoryContents contents = new DirectoryContents();

			contents.listDir = listDir;
			contents.listFile = listFile;
			contents.listSdCard = listSdCard;
			contents.noMedia = noMedia;

			Message msg = handler.obtainMessage(FileManagerActivity.MESSAGE_SHOW_DIRECTORY_CONTENTS);
			msg.obj = contents;
			msg.sendToTarget();
		}

		clearData();
	}

