		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof MultipartKey == false) {
				return false;
			}
			return Arrays.equals(keys, ((MultipartKey) obj).keys);
		}

