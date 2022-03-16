	public JSONArray getSelectedFilesAsJSONArray() {
		JSONArray jarr = new JSONArray();
		Iterator<String> it = getSelectedFiles().keySet().iterator();
		while (it.hasNext()) {
			String pairs = (String)it.next();
			jarr.put(pairs);
			//it.remove(); // avoids a ConcurrentModificationException
		}
		//BLog.e("FEF",FileExploreAdapter.selectedFiles.size()+"--"+ jarr.toString());
		return jarr;
	}

