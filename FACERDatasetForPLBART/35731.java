    /**
     * 查询所有热门城市
     *
     * @return 热门城市列表
     */
    public List<HotCity> queryAllHotCity() {
        try {
            return hotCityDaoOperation.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

