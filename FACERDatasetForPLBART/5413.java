	/**
	 * Method to search files in specified directory
	 * @param dir
	 * @param text
	 * @return
	 */
	public List<String> find(File dir,String text){
		if(!dir.isDirectory())
			return null;
		for(File temp:file.listFiles()) {
			if (file.isDirectory()) {
				find(temp,text);
			}else if(temp.getName().contains(text)){
				fileList.add(temp.getName());
			}
		}
		return fileList;
	}

