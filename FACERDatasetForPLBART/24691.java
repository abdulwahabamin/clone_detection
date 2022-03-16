	/**
	 * 在SD卡上创建文件
	 * 
	 * @throws IOException
	 */
	public File creatFileInSDCard(String fileName, String dir)
			throws IOException {
		File file = new File(SDCardRoot + dir + File.separator + fileName);
		file.createNewFile();
		return file;
	}

