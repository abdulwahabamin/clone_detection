	void searchUtil(File dir,List<FileDirectory> resultList,String query){
		for(File fileItem:dir.listFiles()){
			String ext=MimeTypeMap.getFileExtensionFromUrl(fileItem.getName().replace(" ",""));
			//Log.e(TAG,"Extension: "+ext);
			if(fileItem.isDirectory()) {
				if(FileEx.containsIgnoreCase(fileItem.getName(),query))
					searchResultList.add(new FileDirectory(fileItem.getName(), FileDirectory.FILE,
							getAbsoluteFileSize(fileItem.getAbsolutePath()), simpleDateFormat.format(file.lastModified()),
							fileItem.getAbsolutePath()));

				searchUtil(fileItem,resultList,query);
			}

			else if( query.equals(DOC_SELECTOR) && !FileEx.containsIgnoreCase(ext,"jpg")
					&& (FileEx.containsIgnoreCase(ext,"zip")
					|| FileEx.containsIgnoreCase(ext,"pdf")
					|| FileEx.containsIgnoreCase(ext,"xls")
					|| FileEx.containsIgnoreCase(ext,"xlsx"))){

				searchResultList.add(new FileDirectory(fileItem.getName(), FileDirectory.FILE,
						getAbsoluteFileSize(fileItem.getAbsolutePath()), simpleDateFormat.format(file.lastModified()),
						fileItem.getAbsolutePath()));
			}

			else if(FileEx.containsIgnoreCase(fileItem.getName(),query)){

				searchResultList.add(new FileDirectory(fileItem.getName(), FileDirectory.FILE,
						getAbsoluteFileSize(fileItem.getAbsolutePath()), simpleDateFormat.format(file.lastModified()),
						fileItem.getAbsolutePath()));
			}

		}
	}

