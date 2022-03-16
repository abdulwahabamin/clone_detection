    private JSONArray getConditionFromFile(AssetManager assetManager) {
        try {
            InputStream inputStream = assetManager.open(FILE_NAME);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
            return new JSONArray(total.toString());
        } catch(IOException e) {
            Log.e(LOG_TAG, "Unable to read conditions json file, " + e);
        } catch(JSONException e) {
            Log.e(LOG_TAG, "Unable to parse conditions json, " + e);
        }
            return null;
    }

