		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			buffer.append(mValues[calendar.get(mField)]);
		}

