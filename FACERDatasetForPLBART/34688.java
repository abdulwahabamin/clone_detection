    private void initEvent() {
        cardViewGroup.setRemoveListener(new SlideCutListView.RemoveListener() {
            @Override
            public void removeItem(SlideCutListView.RemoveDirection direction, int position) {
                String name = ((CityManageContext)mAdapter.getItem(position)).getCityName();
                if (name.equals(mPresenter.getShowCity())) {
                    AlertDialog.Builder dialogBuilder;
                    if (MyApplication.nightMode2()){
                        dialogBuilder  = new AlertDialog.Builder(getActivity(), R.style.NightDialog);
                    }else{
                        dialogBuilder = new AlertDialog.Builder(getActivity());
                    }
                    dialogBuilder.setMessage("该城市为首页城市，无法删除，如�?删除，请指定�?�一首页城市").
                            setPositiveButton("�?�", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }else{
                    mPresenter.deleteCity(name);
                }

            }
        });

        cardViewGroup.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String name = ((CityManageContext) parent.getItemAtPosition(position)).getCityName();
                AlertDialog.Builder dialogBuilder;
                if (MyApplication.nightMode2()){
                    dialogBuilder  = new AlertDialog.Builder(getActivity(), R.style.NightDialog);
                }else{
                    dialogBuilder = new AlertDialog.Builder(getActivity());
                }
                dialogBuilder.setMessage("是�?�将" + name + "设置为首页城市").
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogUtils.e("name",name);
                                LogUtils.e("show",mPresenter.getShowCity());
                                if(name.equals(mPresenter.getShowCity())){
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "该城市已�?是首页城市",Toast.LENGTH_SHORT).show();
                                }else{
                                    mPresenter.updateShowCity(name);
                                    EventBus.getDefault().post(new MessageEvent(UPDATE_WEATHER));
                                }
                            }
                        }).setNegativeButton("�?�", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogUtils.e("name",name);
                                LogUtils.e("show",mPresenter.getShowCity());
                            }
                        }).show();
                return true;
            }
        });
    }

