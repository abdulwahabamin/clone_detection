	private static void add(String mimeType, String extension) {
		//
		// if we have an existing x --> y mapping, we do not want to
		// override it with another mapping x --> ?
		// this is mostly because of the way the mime-type map below
		// is constructed (if a mime type maps to several extensions
		// the first extension is considered the most popular and is
		// added first; we do not want to overwrite it later).
		//
		if (!mimeTypeToExtensionMap.containsKey(mimeType)) {
			mimeTypeToExtensionMap.put(mimeType, new ArrayList<String>());
		}
		if (!mimeTypeToExtensionMap.get(mimeType).contains(extension)) {
			mimeTypeToExtensionMap.get(mimeType).add(extension);
		}

		if (!extensionToMimeTypeMap.containsKey(extension)) {
			extensionToMimeTypeMap.put(extension, new ArrayList<String>());
		}
		if (!extensionToMimeTypeMap.get(extension).contains(mimeType)) {
			extensionToMimeTypeMap.get(extension).add(mimeType);
		}
	}

