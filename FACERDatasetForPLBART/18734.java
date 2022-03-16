	@Override
	public AddPlaylistResponse fromJsonObject(JSONObject jsonObject)
	{
		if(jsonObject != null)
		{
			mId = jsonObject.optString("id", null);
			mTitle = jsonObject.optString("title", null);
			mSuccess = jsonObject.optBoolean("success");
		}

		// return this object to allow chaining
		return this;
	}

