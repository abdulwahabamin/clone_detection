	/**
	 * Method get total space in Root directory set at object creation time
	 *
	 * @return String
	 */
	public String getTotalRootSpace() {
		try {
			file = new File(defaultDir);
			double size = 0;
			size = file.getTotalSpace();
			StringBuilder unit = new StringBuilder("");
			if (isExists(defaultDir)) {
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
			//Log.e("SIZE",""+size);
			return String.format("%.2f", size) + " " + unit;

		} catch (NullPointerException e) {
			return null;
		}
	}

