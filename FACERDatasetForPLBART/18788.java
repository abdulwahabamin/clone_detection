	@Override
	public ArrayList<WebClientSongsSchema> fromJsonArray(JSONArray jsonArray) {
		
		ArrayList<WebClientSongsSchema> songList = new ArrayList<WebClientSongsSchema>();
		if(jsonArray != null && jsonArray.length() > 0) {
			for(int i = 0; i < jsonArray.length(); i++) {
				try {
					WebClientSongsSchema song = new WebClientSongsSchema().fromJsonObject(jsonArray.getJSONObject(i));
					songList.add(song);
					
				} catch(JSONException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		return songList;
	}

