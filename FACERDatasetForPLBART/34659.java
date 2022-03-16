    @Override
    public void showProvinceData(List<ProvinceEntity> datas) {
        for (ProvinceEntity item : datas) {
            ProvinceContext province = new ProvinceContext();
            province.setName(item.getProvinceName());
            province.setImage(R.mipmap.ic_keyboard_arrow_right_black_24dp);
            provinces.add(province);
        }
    }

