    @Override
    public void getAllMyCities(final Action1<List<MyCity>> action) {
        Observable.create(new Observable.OnSubscribe<List<MyCity>>() {
            @Override
            public void call(final Subscriber<? super List<MyCity>> subscriber) {
                MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        subscriber.onStart();
                        ;
                        subscriber.onNext(getMyCities());
                    }
                });
            }
        }).subscribe(action);
    }

