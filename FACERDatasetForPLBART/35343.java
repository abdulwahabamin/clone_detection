    private void initEvent() {
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetail();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoData();
                mPresenter.doRefreshInNoData();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("被点击");
                mPresenter.generateDataInPopView();
            }
        });
    }

