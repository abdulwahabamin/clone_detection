		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			int value = calendar.get(Calendar.HOUR_OF_DAY);
			if (value == 0) {
				value = calendar.getMaximum(Calendar.HOUR_OF_DAY) + 1;
			}
			mRule.appendTo(buffer, value);
		}

