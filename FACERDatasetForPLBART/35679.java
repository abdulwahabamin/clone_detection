     public <T,N> void rxRequest(Observable<T> observable, Subscriber<N> subscriber,
                                 BaseFlatMapOp<T,N> baseFlatMapOp){
         observable.subscribeOn(Schedulers.io()).
                 unsubscribeOn(Schedulers.io()).
                 flatMap(baseFlatMapOp).
                 observeOn(AndroidSchedulers.mainThread()).
                 subscribe(subscriber);
     }

