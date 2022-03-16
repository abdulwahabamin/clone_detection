		/**
		 * Constructs an instance of {@code TimeZoneNameRule} with the specified
		 * properties.
		 * 
		 * @param timeZone
		 *            the time zone
		 * @param locale
		 *            the locale
		 * @param style
		 *            the style
		 */
		TimeZoneNameRule(TimeZone timeZone, Locale locale, int style) {
			mTimeZone = timeZone;

			mStandard = getTimeZoneDisplay(timeZone, false, style, locale);
			mDaylight = getTimeZoneDisplay(timeZone, true, style, locale);
		}

