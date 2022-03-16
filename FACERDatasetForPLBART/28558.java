    /**
     * This method handles the click event on the 'Search' button.
     */

    private void handleOnButtonSearchClick() {
        // Retrieve all necessary inputs (convert the edgeLength if necessary)
        int edgeLength = sbEdgeLength.getProgress() + minEdgeLength;
        int numberOfReturnCities = sbNumReturns.getProgress() + minNumberOfReturns;
        if (prefManager.isDistanceUnitMiles()) {
            edgeLength = Math.round(prefManager.convertMilesInKm(edgeLength));
        }

        // Procedure for retrieving the city (only necessary if no item from the drop down list
        // was selected)

        if (dropdownSelectedCity == null) {
            cityTextViewGenerator.getCityFromText(true);
            if (dropdownSelectedCity == null) {
                return;
            }
        }

        IHttpRequestForRadiusSearch radiusSearchRequest = new OwmHttpRequestForRadiusSearch(getApplicationContext());
        radiusSearchRequest.perform(dropdownSelectedCity.getCityId(), edgeLength, numberOfReturnCities);
    }

