    /**
     * 查询表中的所有城市
     *
     * @return 城市列表数�?�
     */
    public List<City> queryCityList() {

        try {
            return cityDaoOperation.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

