	/**
	 * Method to get used space for the root directory set at object creation time
	 *
	 * @return
	 */
	public String getUsedRootSpace() {
		double total, used, free;
		total = Double.parseDouble(getTotalRootSpace().split(" ")[0]);
		free = Double.parseDouble(getFreeRootSpace().split(" ")[0]);
		if(free > total){
			free/=1000;
		}
		return String.format(Locale.US,"%.2f",(total - free)) + " GB";
	}

