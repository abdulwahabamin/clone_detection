        @Override
        protected String doInBackground(String... params) {
            InputStream inputStream = null;
            URL url;
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(15000); //15 sec
                inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                return convertInputStreamToString(inputStream);
            } catch (IOException e) {
                Log.e(LOG_TAG, e.getMessage());
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    Log.e(LOG_TAG, e.getMessage());
                }
            }
            return null;
        }

