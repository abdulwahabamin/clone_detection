    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.share_weather:
                CoreManager.getImpl(ICoreProvider.class).showShareDialog(this,true);
                break;
            case R.id.share_app:
                CoreManager.getImpl(ICoreProvider.class).showShareDialog(this,false);
                break;
            case R.id.about:
                CoreManager.getActivityRouter(IActivityRouter.class).toAboutActivity();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

