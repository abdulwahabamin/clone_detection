    @Override
    public void dragCity(int cityOrderFrom, int cityOrderTo) {
        Intent intent = new Intent(this, GeneralDatabaseService.class);
        intent.setAction(GeneralDatabaseService.ACTION_DRAG_CITY);
        intent.putExtra(CITY_ORDER_FROM, cityOrderFrom);
        intent.putExtra(CITY_ORDER_TO, cityOrderTo);
        startService(intent);
    }

