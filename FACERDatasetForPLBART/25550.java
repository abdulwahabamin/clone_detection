	public static List<String> getExtensionsFromMimeType(String mimeType) {
		if (mimeType == null) {
			return Collections.emptyList();
		}
		return mimeTypeToExtensionMap.get(mimeType);
	}

