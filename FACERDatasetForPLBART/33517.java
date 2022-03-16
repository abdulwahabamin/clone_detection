    @Override
    protected void onPostExecute(SearchResponseForFindQuery result) {
        super.onPostExecute(result);
        if (result == null || result.getCode() != JsonFetcher.HTTP_STATUS_CODE_OK) {
            displayErrorMessage();
        } else if (result.getCount() < 1) {
            showNoCitiesFoundAlertDialog();
        } else {
            dealWithSearchResponseForFindCitiesQuery(result);
        }
    }

