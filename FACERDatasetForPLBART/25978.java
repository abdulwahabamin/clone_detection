		/**
		 * {@inheritDoc}
		 */
		public int estimateLength() {
			return Math.max(mStandard.length(), mDaylight.length());
		}

