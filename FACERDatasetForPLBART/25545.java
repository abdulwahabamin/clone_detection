	/**
	 * Returns true if the given MIME type has an entry in the map.
	 *
	 * @param mimeType A MIME type (i.e. text/plain)
	 * @return True iff there is a mimeType entry in the map.
	 */
	public static boolean hasMimeType(String mimeType) {
		if (mimeType == null || mimeType.isEmpty()) {
			return false;
		}
		return mimeTypeToExtensionMap.containsKey(mimeType);
	}

