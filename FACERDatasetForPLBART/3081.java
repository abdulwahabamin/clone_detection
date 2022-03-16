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
		
		/** Dir separate for sorting */
		List<IconifiedText> listDir = new ArrayList<IconifiedText>(totalCount);

		/** Files separate for sorting */
		List<IconifiedText> listFile = new ArrayList<IconifiedText>(totalCount);

		/** SD card separate for sorting */
		List<IconifiedText> listSdCard = new ArrayList<IconifiedText>(3);

		boolean noMedia = false;

		// Cache some commonly used icons.
		Drawable sdIcon = context.getResources().getDrawable(R.drawable.icon_sdcard);
		Drawable folderIcon = context.getResources().getDrawable(R.drawable.ic_launcher_folder);
		Drawable genericFileIcon = context.getResources().getDrawable(R.drawable.icon_file);

		Drawable currentIcon = null; 

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

				/*
		  if (currentFile.isHidden()) {
			  continue;
		  }
				 */
				if (currentFile.isDirectory()) {
					if (currentFile.getAbsolutePath().equals(mSdCardPath)) {
						currentIcon = sdIcon;

						listSdCard.add(new IconifiedText(
								currentFile.getName(), "", currentIcon));
					} else {
						currentIcon = folderIcon;

						listDir.add(new IconifiedText(
								currentFile.getName(), "", currentIcon));
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

					currentIcon = getDrawableForMimetype(currentFile, mimetype);
					if (currentIcon == null) {
						currentIcon = genericFileIcon;
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
						// but this is just a Cupcake 1.1 fallback, and KB is universal
						// enough.
					}

					listFile.add(new IconifiedText(
							currentFile.getName(), size, currentIcon));
				}
			}
		}
		
		Log.v(TAG, "Sorting results...");
		
		//Collections.sort(mListSdCard); 
		Collections.sort(listDir); 
		Collections.sort(listFile); 

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

