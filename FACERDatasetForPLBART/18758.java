	/**************************************************************************************
	 * Reorders the specified song (within the specified playlist) to a new position.
	 * 
	 * @param context The context to use during the reordering process.
	 * @param playlistId The id of the playlist which contains the song to be reordered.
	 * @param movedSongId The id of the song that is being reordered.
	 * @param movedEntryId The entryId of the song that is being reordered.
	 * @param afterEntryId The entryId of the song that is before the new position.
	 * @param beforeEntryId The entryId of the song that is after the new position.
	 * @return Returns the JSON response of the reorder task.
	 * @throws JSONException
	 **************************************************************************************/
	public static final String reorderPlaylistEntryWebClient(Context context,
														String playlistId, 
														ArrayList<String> movedSongId, 
														ArrayList<String> movedEntryId,
														String afterEntryId, 
														String beforeEntryId) throws JSONException {
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("playlistId", playlistId);
		jsonParam.put("movedSongIds", movedSongId);
		jsonParam.put("movedEntryIds", movedEntryId);
		jsonParam.put("afterEntryId", afterEntryId);
		jsonParam.put("beforeEntryId", beforeEntryId);
		
		String jsonParamString = jsonParam.toString();
		jsonParamString = jsonParamString.replace("\"[", "[\"");
		jsonParamString = jsonParamString.replace("]\"", "\"]");
		
		JSONForm form = new JSONForm();
		form.addField("json", jsonParamString);
		form.close();
		
		String result = mHttpClient.post(context, 
										 "https://play.google.com/music/services/changeplaylistorder?u=0&xt=" + getXtCookieValue(), 
										 new ByteArrayEntity(form.toString().getBytes()), 
										 form.getContentType());
		
		return result;
	}

