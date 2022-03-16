	@Override
	public QueryResults fromJsonObject(JSONObject jsonObject)
	{
		if(jsonObject != null)
		{
			JSONArray jsonArray = jsonObject.optJSONArray("artists");
			mArtists = (ArrayList<WebClientSongsSchema>) fromJsonArray(jsonArray);

			jsonArray = jsonObject.optJSONArray("albums");
			mAlbums = (ArrayList<WebClientSongsSchema>) fromJsonArray(jsonArray);

			jsonArray = jsonObject.optJSONArray("songs");
			mWebClientSongsSchemas = (ArrayList<WebClientSongsSchema>) fromJsonArray(jsonArray);
		}

		// return this object to allow chaining
		return this;
	}

