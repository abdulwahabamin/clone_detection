	public static String createFileNameFromUrl(String url) {
		url=url.replaceFirst("http://", "");
		String ext = url.substring(url.lastIndexOf("."),url.length());
		
		
		url=url.replaceAll("[^_A-Za-z0-9]", "");
		return url+ext;
	}

