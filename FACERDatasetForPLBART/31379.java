    private boolean getCityIdFromLocation() {
        if (mLocationEntity == null && mListCities == null)
            return false;

        boolean ret = false;
        for (CityEntity cityEntity : mListCities) {
            if (mLocationEntity.getProvince().contains(cityEntity.getProvince()) || cityEntity.getProvince().contains(mLocationEntity.getProvince())) {
                if (mLocationEntity.getDistrict().contains(cityEntity.getCity()) || cityEntity.getCity().contains(mLocationEntity.getDistrict())) {
                    mCityId = cityEntity.getCityId();
                    ret = true;
                    break;
                }
            }
        }

        if (!ret) {
            for (CityEntity cityEntity : mListCities) {
                if (mLocationEntity.getProvince().contains(cityEntity.getProvince()) || cityEntity.getProvince().contains(mLocationEntity.getProvince())) {
                    if (mLocationEntity.getCity().contains(cityEntity.getCity()) || cityEntity.getCity().contains(mLocationEntity.getCity())) {
                        mCityId = cityEntity.getCityId();
                        ret = true;
                        break;
                    }
                }
            }
        }

        return ret;
    }

