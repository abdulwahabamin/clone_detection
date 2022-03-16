	/**
	 * Native helper method, returns whether the current process has execute privilages.
	 * @param a File
	 * @return returns TRUE if the current process has execute privilages.
	 */
	public static boolean canExecute(File mContextFile) {
		try {
			// File.canExecute() was introduced in API 9.  If it doesn't exist, then
			// this will throw an exception and the NDK version will be used.
			Method m = File.class.getMethod("canExecute", new Class[] {} );
			Boolean result=(Boolean)m.invoke(mContextFile);
			return result;
		} catch (Exception e) {
			if(libLoadSuccess){
				return access(mContextFile.getPath(), X_OK);
			} else {
				return false;
			}
		}
	}

