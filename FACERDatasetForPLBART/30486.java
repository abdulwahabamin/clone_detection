    /**
     * 获�?�数�?�
     */
    private void getData(List<CityBean> cityBeans, boolean first) {
        fragments = new ArrayList<>();
        llRound.removeAllViews();
        for (CityBean city : cityBeans) {
            String cityId = city.getCityId();
            cityIds.add(cityId);
            WeatherFragment weatherFragment = WeatherFragment.newInstance(cityId);
            fragments.add(weatherFragment);
        }
        if (cityIds.get(0).equalsIgnoreCase(ContentUtil.NOW_CITY_ID)) {
            ivLoc.setVisibility(View.VISIBLE);
        } else {
            ivLoc.setVisibility(View.INVISIBLE);
        }
        View view;
        for (int i = 0; i < fragments.size(); i++) {
            //创建底部指示器(�?圆点)
            view = new View(MainActivity.this);
            view.setBackgroundResource(R.drawable.background);
            view.setEnabled(false);
            //设置宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtil.dip2px(this, 4), DisplayUtil.dip2px(this, 4));
            //设置间隔
            if (fragments.get(i) != fragments.get(0)) {
                layoutParams.leftMargin = 10;
            }
            //添加到LinearLayout
            llRound.addView(view, layoutParams);
        }
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        //第一次显示�?白点
        llRound.getChildAt(0).setEnabled(true);
        mNum = 0;
        if (fragments.size() == 1) {
            llRound.setVisibility(View.GONE);
        } else {
            llRound.setVisibility(View.VISIBLE);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (cityIds.get(i).equalsIgnoreCase(ContentUtil.NOW_CITY_ID)) {
                    ivLoc.setVisibility(View.VISIBLE);
                } else {
                    ivLoc.setVisibility(View.INVISIBLE);
                }
                llRound.getChildAt(mNum).setEnabled(false);
                llRound.getChildAt(i).setEnabled(true);
                mNum = i;
                tvLocation.setText(locaitons.get(i));
                if (ContentUtil.SYS_LANG.equalsIgnoreCase("en")) {
                    tvLocation.setText(locaitonsEn.get(i));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        if (!first && fragments.size() > 1) {
            viewPager.setCurrentItem(1);
            getNow(cityIds.get(1), false);
        } else {
            viewPager.setCurrentItem(0);
            getNow(ContentUtil.NOW_LON + "," + ContentUtil.NOW_LAT, true);
        }
    }

