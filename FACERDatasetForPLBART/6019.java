    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getTotalSpace();
                        getFreeSpace();
                        mSwipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(FileActivity.this, "内存信�?�更新完�?。", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

