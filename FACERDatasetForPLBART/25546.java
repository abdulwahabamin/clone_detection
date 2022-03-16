	/**
	 * Returns the MIME type for the given extension.
	 *
	 * @param extension A file extension without the leading '.'
	 * @return The MIME type for the given extension or null iff there is none.
	 */
	public static String guessMimeTypeFromExtension(String extension) {
		if (extension == null || extension.isEmpty()) {
			return null;
		}
		return extensionToMimeTypeMap.get(extension).get(0);
	}

