        /**
         * Obtains an input stream to be decoded into a bitmap.
         *
         * @param iconCode Open Weather Map code for the weather conditions
         * @return an input stream for the weather icon
         */
        private InputStream getInputStream(String iconCode) {
            String iconUrl = Weather.ICON_URL_PREFIX + iconCode + Weather.ICON_URL_SUFFIX;
            InputStream input;
            try {
                URL url = new URL(iconUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                input = connection.getInputStream();
            } catch (MalformedURLException e) {
                MiscMethods.log("MalformedURLException during SetIconDrawableTask");
                return null;
            } catch (IOException e) {
                MiscMethods.log("IOException during SetIconDrawableTask");
                return null;
            }
            return input;
        }

