	/**
	 * Method get free space in Root directory set at object creation time
	 *
	 * @return
	 */

	public String getFreeRootSpace() {
		try {
			file = new File(defaultDir);
			double size = 0;
			size = file.getFreeSpace();
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

			return String.format("%.2f", size) + " " + unit;

		} catch (NullPointerException e) {
			return null;
		}
	}

