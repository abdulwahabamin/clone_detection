        @Override
        public void onEvent(AMapLocation aMapLocation) {
            LocationManager.get().removeLocationObserver(mLocationObserver);
            String city = null;
            if (aMapLocation.getErrorCode() == 0) {
                city = Utils.formatCity(aMapLocation.getCity(), aMapLocation.getDistrict());
            } else {
                view.showSnack(view.getContext().getString(R.string.locate_fail));
            }
            onLocated(city);
        }

