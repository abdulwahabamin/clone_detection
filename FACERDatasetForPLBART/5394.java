	/**
	 * Method to rename the file for given path.
	 * @param path path of file to be renamed.
	 * @param newName new name for file.
	 * @return
	 */

	public boolean renameTo(String path,String newName){
		File parent=new File(path).getParentFile();
		File newFile=new File(parent.getAbsolutePath()+"/"+newName);
		return new File(path).renameTo(newFile);
	}

