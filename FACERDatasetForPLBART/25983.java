		/**
		 * Constructs an instance of {@code TimeZoneDisplayKey} with the
		 * specified properties.
		 * 
		 * @param timeZone
		 *            the time zone
		 * @param daylight
		 *            adjust the style for daylight saving time if {@code true}
		 * @param style
		 *            the timezone style
		 * @param locale
		 *            the timezone locale
		 */
		TimeZoneDisplayKey(TimeZone timeZone, boolean daylight, int style,
                           Locale locale) {
			mTimeZone = timeZone;
			if (daylight) {
				style |= 0x80000000;
			}
			mStyle = style;
			mLocale = locale;
		}

