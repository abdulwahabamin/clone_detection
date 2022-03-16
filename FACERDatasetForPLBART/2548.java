	/**
	 * Get the file extension of the selected file
	 * @param currentFile the file currently selected
	 * @return the extension of the selected file
	 */
	public String getFileExt(File currentFile) {
		MimeTypeMap mime = MimeTypeMap.getSingleton();
		String ext = currentFile.getName().substring(currentFile.getName().indexOf(".") + 1);
		String type = mime.getMimeTypeFromExtension(ext);
		return type;
	}

