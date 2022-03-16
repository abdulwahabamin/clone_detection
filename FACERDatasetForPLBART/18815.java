	@Override
	public MobileClientPlaylistsSchema fromJsonObject(JSONObject jsonObject) {
		if(jsonObject != null) {
			mKind = jsonObject.optString("kind", null);
			mPlaylistId = jsonObject.optString("id", null);
			mCreationTimestamp = jsonObject.optString("creationTimestamp");
			mLastModifiedTimestamp = jsonObject.optString("lastModifiedTimestamp", null);
			mRecentTimestamp = jsonObject.optString("recentTimestamp");
			mDeleted = jsonObject.optBoolean("deleted");
			mName = jsonObject.optString("name");
			mType = jsonObject.optString("type");
			mShareToken = jsonObject.optString("shareToken");
			mOwnerName = jsonObject.optString("ownerName");
			mOwnerProfilePhotoUrl = jsonObject.optString("ownerProfilePhotoUrl");
			mAccessControlled = jsonObject.optBoolean("accessControlled");
		}

		//This method returns itself to support chaining.
		return this;
	}

