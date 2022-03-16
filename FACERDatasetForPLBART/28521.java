    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            String temperature = main.getString("temp");
            String placeName = myObject.getString("name");

            MainActivity.place.setText(placeName);
            MainActivity.temp.setText(temperature);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

