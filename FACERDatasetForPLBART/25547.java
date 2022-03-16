	public static List<String> getMimeTypesFromExtension(String extension) {
		if (extension == null) {
			return Collections.emptyList();
		}
		return extensionToMimeTypeMap.get(extension);
	}

