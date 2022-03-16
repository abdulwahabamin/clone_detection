    @Override
    public void loadData() {

        List<ProvinceEntity> provinces = mRepository.getAllProvince();
        mView.showProvinceData(provinces);

    }

