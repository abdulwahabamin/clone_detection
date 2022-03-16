		/**
		 * {@inheritDoc}
		 */
		public void appendTo(StringBuffer buffer, Calendar calendar) {
			int offset = calendar.get(Calendar.ZONE_OFFSET)
					+ calendar.get(Calendar.DST_OFFSET);

			if (offset < 0) {
				buffer.append('-');
				offset = -offset;
			} else {
				buffer.append('+');
			}

			int hours = offset / (60 * 60 * 1000);
			buffer.append((char) (hours / 10 + '0'));
			buffer.append((char) (hours % 10 + '0'));

			if (mColon) {
				buffer.append(':');
			}

			int minutes = offset / (60 * 1000) - 60 * hours;
			buffer.append((char) (minutes / 10 + '0'));
			buffer.append((char) (minutes % 10 + '0'));
		}

