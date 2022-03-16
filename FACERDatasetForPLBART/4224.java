	public static void doSearch(Context context, String term, BCallback callback) {
		if(term !=null) {
			
			ArrayList<String> st=getWords(term.toLowerCase());

			IndexerDb.init(context);
			results = IndexerDb.searchByString(st);

			Log.e("SEARCH","SEARCH FOUND RESULTS :"+results.size());
			long last24 = Cal.getUnixTime()-(1000*60*60*24);

			// add ratings
			for(IndexerFile result: results) {
				if(st.size()>1) {
					for (String param : st) {
						if(result.getString(IndexerFile.STRING_FILENAME).indexOf(param)!=-1)
							result.rating++;
						if(result.getString(IndexerFile.STRING_FILEPATH).indexOf(param)!=-1)
							result.rating++;
					}
				}
				if(result.getLong(IndexerFile.LONG_MODIFIED)>last24)
					result.rating++;
				if(result.getLong(IndexerFile.LONG_FILESIZE)>50000)
					result.rating++;
			}
			reOrderResults();
		}


		if(callback!=null)
			callback.callback();
	}

