		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			return (mStyle * 31 + mLocale.hashCode()) * 31
					+ mTimeZone.hashCode();
		}

