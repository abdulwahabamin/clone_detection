		/**
		 * {@inheritDoc}
		 */
		public final void appendTo(StringBuffer buffer, int value) {
			if (value < 100) {
				for (int i = mSize; --i >= 2;) {
					buffer.append('0');
				}
				buffer.append((char) (value / 10 + '0'));
				buffer.append((char) (value % 10 + '0'));
			} else {
				int digits;
				if (value < 1000) {
					digits = 3;
				} else {
					digits = Integer.toString(value).length();
				}
				for (int i = mSize; --i >= digits;) {
					buffer.append('0');
				}
				buffer.append(Integer.toString(value));
			}
		}

