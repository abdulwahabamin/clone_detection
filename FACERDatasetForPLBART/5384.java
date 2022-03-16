	public static Map<String, File> getAllStorageLocations() {
		Map<String, File> storageLocations = new HashMap<>(10);
		File storage = Environment.getExternalStorageDirectory();
		storageLocations.put("Internal Storage",storage);
		storage=storage.getParentFile().getParentFile();
		int i=1;
		for (File media:storage.listFiles()){
			if(!media.getName().equals("self") && !media.getName().equals("emulated")){
				storageLocations.put("External Storage "+i,media);
				i++;
			}
		}
		return storageLocations;
	}

