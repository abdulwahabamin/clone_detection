    @Override
    public void onDestroy() {
        super.onDestroy();

        serverService.cancel();
    }

