        public LocationUpdateServiceActionsWithParams(
                LocationUpdateService.LocationUpdateServiceActions locationUpdateServiceAction,
                boolean byLastLocationOnly,
                android.location.Location inputLocation,
                Address address) {
            this.locationUpdateServiceAction = locationUpdateServiceAction;
            this.byLastLocationOnly = byLastLocationOnly;
            this.address = address;
            this.inputLocation = inputLocation;
        }

