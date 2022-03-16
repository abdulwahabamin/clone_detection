	public boolean readDirectory(final Context context)		{
		if(rawList==null)
			loadDirectory();

		useRaw=true;
        folderCats= IndexerDb.getDb().getSubFolderCategories(getPath());
        //BLog.e("FOUND CATS: "+folderCats.size()+"- "+folderCats.keySet().toString());
		int clen=0;


		if(rawList!=null) {
			//clen=rawList.length;
			fileList = new ArrayList<FileItem>();
			for (int i = 0; i < rawList.size(); i++) {
                if(showSystemFiles || (!showSystemFiles && !rawList.get(i).startsWith(".")) ) {

                    // Convert into file path
                    File sel = new File(currentPath, rawList.get(i));

                    FileItem item = new FileItem(rawList.get(i), Files.getFileRIcon(rawList.get(i)), currentPath);


                    if (sel.isDirectory()) {
                        IndexerFile idf=folderCats.get(item.getName());
                        if(idf!=null) {
							item.icon=Files.getFoldersRIcon(idf.getInt(IndexerFile.INT_CATEGORY));

                        } else {
                            item.icon = Files.F_DIR; //R.drawable.directory_icon;
                        }
                        //item.isDir = true;
                    }
                    fileList.add(item);
                }

			}
			double len = fileList.size();
			//BLog.e("CP: "+currentPath);
			if(currentPath.endsWith("/Camera")) {
				this.setOrderBy(context, FileManagerBase.ORDER_DATE_DESC);
			} else {

				this.setOrderBy(context, FileManagerBase.ORDER_ALPHA_ASC);
			}
			reOrderFiles(context);
			/*
			if(fileList.size()<300) {
				this.setOrderBy(context, FileManagerBase.ORDER_DATE_ASC);
				reOrderFiles(context);
			} else {
				this.setOrderBy(context, FileManagerBase.ORDER_ORIGINAL);
				reOrderFiles(context);
			}
*/
			//BLog.e("FILEZ", "total: "+len+" - images: "+countImagesue;

		} else {
			fileList = new ArrayList<FileItem>();
		}


		useRaw=false;
		rawList=null;
		return true;
	}

