    @SuppressLint("NewApi")
    public void readAndParseJSON(String in) {
        try {
            JSONObject reader = new JSONObject(in);

            JSONObject sys  = reader.getJSONObject("sys");
            country = sys.getString("country");

            JSONObject main  = reader.getJSONObject("main");
            temperature = main.getInt("temp");
            pressure = main.getString("pressure");
            //humidity = main.getString("humidity");

            parsingComplete = false;



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

