    /**
     * @param data The data that contains the information to retrieve the ID of the city.
     *             If data for a single city were requested, the response string can be
     *             passed as an argument.
     *             If data for multiple cities were requested, make sure to pass only one item
     *             of the response list at a time!
     * @return Returns the ID of the city or Integer#MIN_VALUE in case the data is not well-formed
     * and the information could not be extracted.
     */
    @Override
    public int extractCityID(String data) {
        try {
            JSONObject json = new JSONObject(data);
            return json.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }

