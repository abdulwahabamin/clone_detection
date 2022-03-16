	public String getAbsoluteFileSize(String file) {
		double size = 0;
		StringBuilder unit = new StringBuilder("");
		if (isExists(file)) {
			size = ((double) new File(file).length());
			unit.append("B");
			if (size > 1024) {
				size /= 1024;
				unit.delete(0, unit.length());
				unit.append("KB");
			}

			if (size > 1024) {
				size /= 1024;
				unit.delete(0, unit.length());
				unit.append("MB");

			}

			if (size > 1024) {
				size /= 1024;
				unit.delete(0, unit.length());
				unit.append("GB");

			}

		}
		return String.format("%.2f", size) + " " + unit;
	}

