        void bindLocation(Location location) {
            this.location = location;
            if (location == null) {
                return;
            }
            String orderId = Integer.toString(location.getOrderId());
            mCityName.setText(orderId + getLocationNickname(getBaseContext(), location));
            if (location.getAddress() != null) {
                mCountryName.setText(Utils.getCityAndCountryFromAddress(location.getAddress()));
            }
        }

