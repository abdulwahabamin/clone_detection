		/**
		 * {@inheritDoc}
		 */
		public final void appendTo(StringBuffer buffer, int value) {
			buffer.append((char) (value / 10 + '0'));
			buffer.append((char) (value % 10 + '0'));
		}

