	/**
	 * Retrieve decodeable media types in the system
	 * @return A set containing the supported media types
	 */
	private static Set<String> getSupportedTypes() {
		// These MediaCodecList methods are deprecated in API 21, but the newer
		// ones aren't supported in API < 21
		int numCodecs = MediaCodecList.getCodecCount();
		Set<String> supportedMediaTypes = new HashSet<>();

		for (int codec = 0; codec < numCodecs; codec++) {
			MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(codec);

			if (codecInfo.isEncoder()) {
				continue;
			}

			String[] codecTypes = codecInfo.getSupportedTypes();
			for (int type = 0; type < codecTypes.length; type++) {
				if (isMediaAudio(codecTypes[type]) && !supportedMediaTypes.contains(codecTypes[type])) {
					Log.d(TAG, codecTypes[type] + " is decodeable by " + codecInfo.getName());
					supportedMediaTypes.add(codecTypes[type]);
				}
			}
		}
		return supportedMediaTypes;
	}

