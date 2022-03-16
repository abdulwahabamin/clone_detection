        @Override
        public void onEvent(AMapLocation aMapLocation) {
            view.cancelProgress();
            if (aMapLocation.getErrorCode() == 0) {
                backToWeather(Utils.formatCity(aMapLocation.getCity(), aMapLocation.getDistrict()), true);
            } else {
                view.showSnack(view.getContext().getString(R.string.locate_fail));
            }
        }

