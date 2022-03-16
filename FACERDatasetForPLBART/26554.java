    public void ParseData(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            JSONArray list = reader.getJSONArray("list");
            JSONObject JSONList = list.getJSONObject(0);
            for (int i = 0; i < list.length(); i++) {
                JSONObject forJSONList = list.getJSONObject(i);
                JSONArray forWeather = forJSONList.getJSONArray("weather");
                JSONObject forJSONWeather = forWeather.getJSONObject(0);
                JSONObject fortemp = forJSONList.getJSONObject("temp");
                Log.i("RecyclerView", "JSON Parsing Nr." + i);
                items.add(new Day(forJSONList.getInt("dt"), fortemp.getDouble("max"), fortemp.getDouble("min"), forJSONList.getDouble("pressure"), forJSONList.getInt("humidity"), forJSONWeather.getInt("id"), forJSONWeather.getString("description"), forJSONList.getDouble("speed")));
                Log.i("RecyclerView", "Added items Nr" + i);
                adapter.notifyItemInserted(0);
                Log.i("RecyclerView", "notifyItemInserted Nr." + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("JSON Parsing", e.toString());
        }
    }

