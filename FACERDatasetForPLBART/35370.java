    @Override
    public void showDialog(final String name, final Context context) {
        AlertDialog.Builder dialogBuilder;
        try {
            if (MyApplication.nightMode2()) {
                dialogBuilder = new AlertDialog.Builder(context, R.style.NightDialog);
            } else {
                dialogBuilder = new AlertDialog.Builder(context);
            }
            dialogBuilder.setTitle("系统�??示").setMessage("当�?定�?到的城市为：" + name + ",是�?�将该城市设为首页").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (mCityRepository.isExistInLoveCity(name)) {
                        Toast.makeText(context, "该城市已�?是喜欢城市", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!mCityRepository.isExistInCity(name)) {
                            Toast.makeText(context, "暂无该城市的天气，期待你的�??馈", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mCityRepository.getLoveCity(1, new CityDataSource.GetLoveCityCallBack() {
                            @Override
                            public void onSuccess(List<LoveCityEntity> loveCities) {
                                Logger.d(loveCities.get(0).getCityName() + "  "+ loveCities.get(0).getOrder());
                                mCityRepository.updateLocaitonCityOrder(loveCities.get(0).getCityName(),
                                        mCityRepository.getAllLoveCities().size()+1);
                                LoveCityEntity newLoveCity = new LoveCityEntity();
                                newLoveCity.setCityName(name);
                                newLoveCity.setOrder(1);
                                mCityRepository.addLoveCity(newLoveCity);

                            }

                            @Override
                            public void onFailure(String failureMessage) {
                                Logger.e(failureMessage);
                            }
                        });

                        getNewShowWeather();

                    }
                }
            }).setNegativeButton("�?�消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

