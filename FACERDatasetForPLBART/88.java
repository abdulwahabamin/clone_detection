		public NameAndAddress(String name, String address) {
			if (name == null || name.equals("")) {
				getString(R.string.nonamedevice);
			}
			this.name = name;
			this.address = address;
		}

