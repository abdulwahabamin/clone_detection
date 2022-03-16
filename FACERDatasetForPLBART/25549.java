	/**
	 * Returns the registered extension for the given MIME type. Note that some
	 * MIME types map to multiple extensions. This call will return the most
	 * common extension for the given MIME type.
	 *
	 * @param mimeType A MIME type (i.e. text/plain)
	 * @return The extension for the given MIME type or null iff there is none.
	 */
	public static String guessExtensionFromMimeType(String mimeType) {
		if (mimeType == null || mimeType.isEmpty()) {
			return null;
		}
		return getExtensionsFromMimeType(mimeType).get(0);
	}

