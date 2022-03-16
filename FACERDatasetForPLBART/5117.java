	  public static JSONObject readJsonFromUrl(String url)  {
          //BLog.e("JSON",url);
		  URL serverUrl = null;
          HttpURLConnection urlConnection = null;
          try {
              serverUrl=new URL(url);
              urlConnection = (HttpURLConnection) serverUrl.openConnection();
          } catch(Exception e) {
              //BLog.e("JSON1", "" + e.getMessage());
          }


          JSONObject json=null;
          String useCookie = cookieStore.get(url);
          InputStream is=null;

          if(useCookie!=null) {
              urlConnection.setRequestProperty("Cookie", useCookie);
          }
          try {
              // mock an android header
              urlConnection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
              //urlConnection.setRequestProperty("Content-Type","application/json");
              urlConnection.setRequestMethod("GET");

              urlConnection.setDoOutput(true);
              urlConnection.setDoInput(true);
              urlConnection.setConnectTimeout(URL_TIMEOUT_MILLIS);
              urlConnection.setReadTimeout(URL_TIMEOUT_MILLIS);
              urlConnection.setInstanceFollowRedirects(true);

          } catch(Exception e) {
              //BLog.e("readJsonFromUrl().error.msg","2:"+e.getMessage());
          }
          try {
              //urlConnection.conn
              urlConnection.connect();
          } catch(Exception e) {
              cookieStore.remove(url);
              //BLog.e("readJsonFromUrl().error.msg","3 - connect(): "+e.getMessage());
          }	
          try {
              is = urlConnection.getInputStream();
          } catch(IOException e) {
              //BLog.e("JSON4",""+e.getMessage());
          }
          try {
              BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            //BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String jsonText = readAll(rd);
            //BLog.e("GOTJSON",jsonText+"");
            json= new JSONObject(jsonText);

          } catch(Exception e) {
              //BLog.e("JSON5",""+e.getMessage());
          }
          try {
              is.close();
          } catch(Exception e) {
              //BLog.e("JSON6",""+e.getMessage());
          }
          return json;
	  }

