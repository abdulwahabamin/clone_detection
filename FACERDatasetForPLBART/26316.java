    @OnClick({R2.id.mark, R2.id.suggestion, R2.id.update_version, R2.id.pay})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.mark) {
            openAppMarket();

        } else if (i == R.id.suggestion) {
            ContactActivity.navigationActivity(this);

        } else if (i == R.id.pay) {
            PayActivity.navigationActivity(this);

        } else if (i == R.id.update_version) {
            if (mNewVersionTip.getVisibility() == View.VISIBLE) {

                Beta.checkUpgrade();

            } else {
                Toast.makeText(this, "已是最新版本", Toast.LENGTH_SHORT).show();
            }

        }
    }

