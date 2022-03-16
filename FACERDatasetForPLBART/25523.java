	/**
	 * Return whether the media type is an audio subtype
	 * @param mediaType the media type
	 * @return is it an audio type?
	 */
	private static boolean isMediaAudio(String mediaType) {
		return mediaType.startsWith("audio/");
	}

