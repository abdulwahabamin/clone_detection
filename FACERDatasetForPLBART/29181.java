    @Nullable
    public String getWeatherData(String location) {
        HttpURLConnection con = null ;
        InputStream is = null;
        URL url = null;
        StringBuffer buffer = new StringBuffer();
            try {
                url = new URL(Uri.parse(BASE_URL).buildUpon()
                        .appendQueryParameter("q", location)
                        .appendQueryParameter("APPID", API_KEY)
                        .build().toString());

                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.connect();

                // Let's read the response
                is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while ((line = br.readLine()) != null) {
                    buffer.append(line);
                    buffer.append("\n");
                }
                is.close();
                con.disconnect();
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                try {
                    if (is != null)
                    is.close();
                } catch (Throwable t) {
                }
                try {
                    if (con != null)
                        con.disconnect();
                } catch (Throwable t) {
                }
            }

        return buffer.toString();
    }

