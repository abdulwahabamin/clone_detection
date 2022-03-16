    @Override
    public void updateForecasts(List<Forecast> forecasts) {
        if(refreshActionButton != null && refreshActionButton.getActionView() != null) {
            refreshActionButton.getActionView().clearAnimation();
        }
    }

