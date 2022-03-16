	/**
	 * Method to get complete path of given file name
	 *
	 * @param file
	 * @return
	 */

	public String getFilePath(String file) {

		try {

			return filesPathMap.get(file)!=null
					?filesPathMap.get(file)
					:directoryPathMap.get(file);
		} catch (Exception e) {
			return "File not found!!! ,check files in current diretory by listFiles()";
		}

	}

