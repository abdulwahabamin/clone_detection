	/**
	 * Method to list all contents in current directory
	 *
	 * @return
	 */
	public List<String> listFiles() {
		file = new File(currentDir);
		files = file.listFiles();
		directoryPathMap.clear();
		filesPathMap.clear();
		completeList.clear();
		tempList.clear();
		try {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					directoryPathMap.put(files[i].getName(), files[i].getAbsolutePath());
				} else {
					filesPathMap.put(files[i].getName(), files[i].getAbsolutePath());
				}
			}
		} catch (NullPointerException e) {
			return completeList;
		}

		for (String directory : directoryPathMap.keySet())
			completeList.add(directory);

		Collections.sort(completeList);

		for (String file : filesPathMap.keySet())
			tempList.add(file);

		Collections.sort(tempList);

		completeList.addAll(tempList);
		return completeList;
	}

