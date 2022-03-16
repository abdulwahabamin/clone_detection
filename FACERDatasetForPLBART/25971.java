		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			int value = calendar.get(Calendar.HOUR);
			if (value == 0) {
				value = calendar.getLeastMaximum(Calendar.HOUR) + 1;
			}
			mRule.appendTo(buffer, value);
		}

