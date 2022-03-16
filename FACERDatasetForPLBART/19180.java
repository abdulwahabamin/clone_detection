	/** Given a URI, returns a map of campaign data that can be sent with
	 * any GA hit.
	 *
	 * @param uri A hierarchical URI that may or may not have campaign data
	 *     stored in query parameters.
	 *
	 * @return A map that may contain campaign or referrer
	 *     that may be sent with any Google Analytics hit.
   	 */
	private Map<String,String> getReferrerMapFromUri(Uri uri) {
		 MapBuilder paramMap = new MapBuilder();

		 //If no URI, return an empty Map.
		 if (uri==null) { 
			 return paramMap.build(); 
		 }

		 /* Source is the only required campaign field. No need to continue if not
		  * present. */
		 if (uri.getQueryParameter(CAMPAIGN_SOURCE_PARAM)!=null) {

			 /* MapBuilder.setCampaignParamsFromUrl parses Google Analytics campaign
			  * ("UTM") parameters from a string URL into a Map that can be set on
			  * the Tracker. */
			 paramMap.setCampaignParamsFromUrl(uri.toString());

			 /* If no source parameter, set authority to source and medium to
			  * "referral". */
		 } else if (uri.getAuthority()!=null) {
			 paramMap.set(Fields.CAMPAIGN_MEDIUM, "referral");
			 paramMap.set(Fields.CAMPAIGN_SOURCE, uri.getAuthority());
		 }

		 return paramMap.build();
	}

