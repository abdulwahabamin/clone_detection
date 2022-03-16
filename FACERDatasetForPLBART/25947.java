		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			appendTo(buffer, calendar.get(mField));
		}

