		@Override
		public boolean equals(Object o) {
			if(o == null)
				return false;
			if(!(o instanceof NameAndAddress)) {
				return false;
			}
			NameAndAddress naa = (NameAndAddress)o;
			return naa.name.equals(this.name) && naa.address.equals(this.address);
		}

