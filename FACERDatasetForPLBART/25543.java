	/**
	 * This isn't what the RI does. The RI doesn't have hard-coded defaults, so supplying your
	 * own "content.types.user.table" means you don't get any of the built-ins, and the built-ins
	 * come from "$JAVA_HOME/lib/content-types.properties".
	 */
	private static void applyOverrides() {
		// Get the appropriate InputStream to read overrides from, if any.
		InputStream stream = getContentTypesPropertiesStream();
		if (stream == null) {
			return;
		}
		try {
			try {
				// Read the properties file...
				Properties overrides = new Properties();
				overrides.load(stream);
				// And translate its mapping to ours...
				for (Map.Entry<Object, Object> entry : overrides.entrySet()) {
					String extension = (String) entry.getKey();
					String mimeType = (String) entry.getValue();
					add(mimeType, extension);
				}
			} finally {
				stream.close();
			}
		} catch (IOException ignored) {
		}
	}

