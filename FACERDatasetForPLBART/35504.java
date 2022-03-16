    /**
     * 将所有城市放入数�?�库
     */
    private void addCityData() {
        mCityRepository.addProvince();
        try {
            if (!mCityRepository.isExistInCity()) {
                LoveCityEntity entity = new LoveCityEntity(null, "�?都", 1);
                mCityRepository.addLoveCity(entity);
                Gson gson = new Gson();
                InputStream inputStream = getResources().openRawResource(R.raw.city);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                UrlCity urlCity = gson.fromJson(sb.toString(), UrlCity.class);
                mCityRepository.addCities(urlCity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

