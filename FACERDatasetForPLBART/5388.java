	private void searchUtilDate(File dir, List<FileDirectory> resultList, Date date){
		try {

			for (File fileItem : dir.listFiles()) {
				if (fileItem.isDirectory() && fileItem.getName().length()<15
						&& !isDirToExclude(fileItem.getName())) {
					searchUtilDate(fileItem, resultList, date);
				} else {
					Date tmp=simpleDateFormat.parse(simpleDateFormat.format(fileItem.lastModified()));
					String name=fileItem.getName();
					String ext=MimeTypeMap.getFileExtensionFromUrl(name);

					if(date.compareTo(tmp)<=0 && isValidFile(ext)) {
						searchResultList.add(new FileDirectory(fileItem.getName(), FileDirectory.FILE,
								getAbsoluteFileSize(fileItem.getAbsolutePath()),
								simpleDateFormat.format(fileItem.lastModified()),
								fileItem.getAbsolutePath()));
					}
				}
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}

