		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof TimeZoneDisplayKey) {
				TimeZoneDisplayKey other = (TimeZoneDisplayKey) obj;
				return mTimeZone.equals(other.mTimeZone)
						&& mStyle == other.mStyle
						&& mLocale.equals(other.mLocale);
			}
			return false;
		}

