    @Override
    public LoveCityEntity getLoveCity(int order) {
        List<LoveCityEntity> list = mLoveCityDao.queryBuilder().
                where(LoveCityEntityDao.Properties.Order.eq(order)).list();
        List<LoveCityEntity> tmpList = mLoveCityDao.queryBuilder().list();
        for (int i = 0; i < tmpList.size(); i++) {
            Logger.d(tmpList.get(i).getCityName() + " " + tmpList.get(i).getOrder());
        }
        if (!isListEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }

    }

