    @Override
    public Info doInBackground(String... params) {
        if (params.length == 1)
            city(params);
        else
            coordinates(params);
        try {
            Info array = new Info();
            array.day = gsonWeather();
            array.fort = gsonFort();

            // This value will be 404 if the request was not successful
            if(array.day.getCod() != 200 | array.fort.getCod() != 200) {
                Log.e(LOG_TAG , "Execution Failed");
                return null;
            }
            return array;
        }
        catch(IOException e){
            Log.e(LOG_TAG , "Execution Failed IO");
            e.printStackTrace();
            return null;
        }
    }

