	private static InputStream getContentTypesPropertiesStream() {
		// User override?
		String userTable = System.getProperty("content.types.user.table");
		if (userTable != null) {
			File f = new File(userTable);
			if (f.exists()) {
				try {
					return new FileInputStream(f);
				} catch (IOException ignored) {
				}
			}
		}
		// Standard location?
		File f = new File(System.getProperty("java.home"), "lib" + File.separator + "content-types.properties");
		if (f.exists()) {
			try {
				return new FileInputStream(f);
			} catch (IOException ignored) {
			}
		}
		return null;
	}

