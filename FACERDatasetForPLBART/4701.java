	public boolean readDirectory(final Context context) {
		isImageDir=false;

		loadDirectory();

		int clen=0;
		
		int countImages=0;
		
		if(rawList!=null) {
			clen=rawList.length;
			fileList = new ArrayList<FileItem>();
			for (int i = 0; i < clen; i++) {
                if(showSystemFiles || (!showSystemFiles && !rawList[i].startsWith(".")) ) {

                    // Convert into file path
                    File sel = new File(currentPath, rawList[i]);

                    if (Files.isImage(sel.getName()))
                        countImages++;

                    FileItem item = new FileItem(rawList[i], Files.getFileRIcon(rawList[i]), currentPath);


                    if (sel.isDirectory()) {
                        item.icon = Files.F_DIR; //R.drawable.directory_icon;
                        //item.isDir = true;
                    }
                    //item.size=sel.length();
					//item.
                    fileList.add(item);
                    // Set drawables
                }

			}
			double len = fileList.size();
			
			//BLog.e("FILEZ", "total: "+len+" - images: "+countImages);
			if(countImages/len>0.5D)
				isImageDir=true;

		} else {
			fileList = new ArrayList<FileItem>();
		}
        reOrderFiles(context);

		return true;
	}

