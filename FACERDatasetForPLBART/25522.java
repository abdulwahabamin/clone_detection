	private static String[] getSupportedExtensions() {
		Set<String> extensions = new HashSet<>();

		for(String mediaType : decodeableMediaTypes) {
			if(MediaTypeUtils.getExtensionsFromMimeType(mediaType) == null) {
				Log.w(TAG, "Media type " + mediaType + " doesn't have any associated extension.");
			} else {
				extensions.addAll(MediaTypeUtils.getExtensionsFromMimeType(mediaType));
			}
		}

		return extensions.toArray(new String[extensions.size()]);
	}

