        @Override
        public void onClick(View v) {
            if (rlLifeIndex1.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex1.getTag();
                if (tvDesc1.getVisibility() == View.VISIBLE) {
                    tvDesc1.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow1, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc1.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow1, R.drawable.arrow_open);
                    }
                }
            }
            if (rlLifeIndex2.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex2.getTag();
                if (tvDesc2.getVisibility() == View.VISIBLE) {
                    tvDesc2.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow2, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc2.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow2, R.drawable.arrow_open);
                    }
                }
            }
            if (rlLifeIndex3.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex3.getTag();
                if (tvDesc3.getVisibility() == View.VISIBLE) {
                    tvDesc3.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow3, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc3.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow3, R.drawable.arrow_open);
                    }
                }
            }
            if (rlLifeIndex4.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex4.getTag();
                if (tvDesc4.getVisibility() == View.VISIBLE) {
                    tvDesc4.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow4, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc4.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow4, R.drawable.arrow_open);
                    }
                }
            }
            if (rlLifeIndex5.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex5.getTag();
                if (tvDesc5.getVisibility() == View.VISIBLE) {
                    tvDesc5.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow5, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc5.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow5, R.drawable.arrow_open);
                    }
                }
            }
            if (rlLifeIndex6.equals(v)) {
                CityWeatherPresenter presenter = (CityWeatherPresenter)rlLifeIndex6.getTag();
                if (tvDesc6.getVisibility() == View.VISIBLE) {
                    tvDesc6.setVisibility(View.GONE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow6, R.drawable.arrow_close);
                    }
                } else {
                    tvDesc6.setVisibility(View.VISIBLE);
                    if (presenter != null) {
                        presenter.getImageViewSrc(ivArrow6, R.drawable.arrow_open);
                    }
                }
            }
        }

