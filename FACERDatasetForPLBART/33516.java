    @Override
    protected SearchResponseForFindQuery doInBackground(URL... params) {
        String jsonString;
        try {
            jsonString = new JsonFetcher().getJsonString(params[0]);
        } catch (IOException e) {
            MiscMethods.log("IOException in SearchResponseForFindQuery doInBackground()");
            return null;
        }
        return jsonString == null ? null : new Gson().fromJson(jsonString,
                SearchResponseForFindQuery.class);
    }

