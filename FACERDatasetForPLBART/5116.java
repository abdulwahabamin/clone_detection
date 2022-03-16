    public static JSONObject readJsonFromUrlPlainText(String url)  {
        //BLog.e("JSON",url);
        URL serverUrl = null;
        //HttpURLConnection urlConnection = null;
        try {
            serverUrl=new URL(url);
            //urlConnection = (HttpURLConnection) serverUrl.openConnection();
        } catch(Exception e) {
            //BLog.e("JSONpt1", "" + e.getMessage());
        }


        JSONObject json=null;
        //String useCookie = cookieStore.get(url);
        InputStream is=null;

        try {
            is=serverUrl.openStream();
        } catch(IOException e) {
            //BLog.e("JSONpt2",""+e.getMessage());
        }
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //BLog.e("GOTJSON",jsonText+"");
            json= new JSONObject(jsonText);

        } catch(Exception e) {
            //BLog.e("JSONpt3",""+e.getMessage());
        }
        try {
            is.close();
        } catch(Exception e) {
            //BLog.e("JSONpt4",""+e.getMessage());
        }
        return json;
    }

