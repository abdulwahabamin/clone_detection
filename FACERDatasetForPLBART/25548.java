	/**
	 * Returns true if the given extension has a registered MIME type.
	 *
	 * @param extension A file extension without the leading '.'
	 * @return True iff there is an extension entry in the map.
	 */
	public static boolean hasExtension(String extension) {
		if (extension == null || extension.isEmpty()) {
			return false;
		}
		return extensionToMimeTypeMap.containsKey(extension);
	}

