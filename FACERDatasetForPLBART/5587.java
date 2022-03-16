	/**
	 * Read license from raw resource.
	 * @param resourceid ID of the raw resource.
	 * @return
	 */
	String readTextFromRawResource(int resourceid, boolean preserveLineBreaks) {

		// Retrieve license from resource:
		String license = "";
		Resources resources = getResources();
    		
		//Read in the license file as a big String
		BufferedReader in
		   = new BufferedReader(new InputStreamReader(
				resources.openRawResource(resourceid)));
		String line;
		StringBuilder sb = new StringBuilder();
		try {
			while ((line = in.readLine()) != null) { // Read line per line.
				if (TextUtils.isEmpty(line)) {
					// Empty line: Leave line break
					sb.append("\n\n");
				} else {
					sb.append(line);
					if (preserveLineBreaks) {
						sb.append("\n");
					} else {
						sb.append(" ");
					}
				}
			}
			license = sb.toString();
		} catch (IOException e) {
			//Should not happen.
			e.printStackTrace();
		}
		
    	
    	return license;
	}

