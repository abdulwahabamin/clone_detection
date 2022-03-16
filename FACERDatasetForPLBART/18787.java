	@Override
	public MobileClientPlaylistEntriesSchema fromJsonObject(JSONObject jsonObject) {
		if(jsonObject != null) {
			mKind = jsonObject.optString("kind", null);
			mPlaylistId = jsonObject.optString("playlistId", null);
			mCreationTimestamp = jsonObject.optString("creationTimestamp");
			mLastModifiedTimestamp = jsonObject.optString("lastModifiedTimestamp", null);
			mDeleted = jsonObject.optBoolean("deleted");
			mClientId = jsonObject.optString("clientId");
			mTrackId = jsonObject.optString("trackId");
			mId = jsonObject.optString("id");
			mSource = jsonObject.optString("source");
		}

		//This method returns itself to support chaining.
		return this;
	}

