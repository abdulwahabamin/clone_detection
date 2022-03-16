	public String getAbsoluteInfo(String file) {
		if (isExists(file)) {

			return simpleDateFormat.format(new File(file)
					.lastModified());
		}
		return null;
	}

