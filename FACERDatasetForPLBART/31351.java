        private String getCityName(String cityId) {
            if (cityId != null) {
                for (CityEntity entity : mCities) {
                    if (cityId.equalsIgnoreCase(entity.getCityId())) {
                        return entity.getCity();
                    }
                }
            }

            return null;
        }

