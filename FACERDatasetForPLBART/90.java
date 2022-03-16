		@Override
		public String toString() {
			if(name == null || name.equals("")) {
				return getString(R.string.nonamedevice);
			}
			return name;
		}

