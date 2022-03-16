		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			appendTo(buffer, calendar.get(Calendar.YEAR) % 100);
		}

