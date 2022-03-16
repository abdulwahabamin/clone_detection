	@Override
	public WebClientPlaylistsSchema fromJsonObject(JSONObject jsonObject) {
		if(jsonObject != null) {
			mTitle = jsonObject.optString("title", null);
			mPlaylistId = jsonObject.optString("playlistId", null);
			mRequestTime = jsonObject.optLong("requestTime");
			mContinuationToken = jsonObject.optString("continuationToken", null);
			mDifferentialUpdate = jsonObject.optBoolean("differentialUpdate");
			mContinuation = jsonObject.optBoolean("continuation");

			JSONArray songsArray = jsonObject.optJSONArray("playlist");
			mPlaylist = fromJsonArray(songsArray);
		}

		//This method returns itself to support chaining.
		return this;
	}

