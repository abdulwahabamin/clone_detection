    @Override
    public void refresh() {
        presenter = (AddCityContract.Presenter) adapter.getTag();
        String name = null;
        String remark = null;
        switch (presenter.getType()) {
            case PROVINCE:
                name = data.getProvince();
                break;
            case CITY:
                name = data.getCity();
                break;
            case AREA:
                name = data.getArea();
                remark = presenter.getAddedCity().contains(data.getArea()) ? "已添加" : null;
                break;
            case SEARCH:
                name = data.getArea().concat(" - ").concat(data.getCity()).concat(", ").concat(data.getProvince());
                break;
        }
        tvCity.setText(name);
        tvRemark.setText(remark);
    }

