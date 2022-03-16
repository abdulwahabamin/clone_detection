	public static InitialEnergySettings getInstance() {
		if (singletonRef == null) {
			singletonRef = new InitialEnergySettings();
		}
		return singletonRef;
	}

