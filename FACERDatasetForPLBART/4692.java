	public boolean readDirectory(final Context context) {
		isImageDir=false;

		//BLog.e("FILEM", ""+currentPath);
		File dir = new File(currentPath);
		final String[] fList = dir.list();//.list(filter);

		int clen=0;
		
		int countImages=0;
		
		if(fList!=null) {
			clen=fList.length;
			fileList = new ArrayList<FileItem>();
			for (int i = 0; i < clen; i++) {


                    // Convert into file path
                    File sel = new File(currentPath, fList[i]);

                    if (sel.isDirectory()) {

						FileItem item = new FileItem(fList[i], Files.getFileRIcon(fList[i]), currentPath);


						if (sel.isDirectory()) {
							item.icon = Files.F_DIR; //R.drawable.directory_icon;
							//item.isDir = true;
						}
						//item.size=sel.length();

						fileList.add(item);
					}

			}

			if(countImages/clen>0.5D)
				isImageDir=true;

		} else {
			fileList = new ArrayList<FileItem>();
		}
        reOrderFiles(context);
		return true;

	}

