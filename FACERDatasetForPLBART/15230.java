	/**
	 * Checks if the supplied String <i>may</i> be a Musicbrainz ID. This method returns <code>true</code> for Strings that are
	 * exactly 36 characters long and match the MBID pattern <code>[0-9a-f]{8}\-[0-9a-f]{4}\-[0-9a-f]{4}\-[0-9a-f]{4}\-[0-9a-f]{12}</code>.
	 *
	 * @param nameOrMbid a possible MBID
	 * @return <code>true</code> if this String <i>may</i> be a MBID
	 */
	public static boolean isMbid(String nameOrMbid) {
		// example: bfcc6d75-a6a5-4bc6-8282-47aec8531818
		return nameOrMbid != null && nameOrMbid.length() == 36 && MBID_PATTERN.matcher(nameOrMbid).matches();
	}

