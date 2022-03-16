		/**
		 * {@inheritDoc}
		 */
		public final void appendTo(StringBuffer buffer, int value) {
			if (value < 100) {
				buffer.append((char) (value / 10 + '0'));
				buffer.append((char) (value % 10 + '0'));
			} else {
				buffer.append(Integer.toString(value));
			}
		}

