     public <T> void rxRequest(Observable<T> observable,Subscriber<T> subscriber) {
         observable.subscribeOn(Schedulers.io()).
                 unsubscribeOn(Schedulers.io()).
                 observeOn(AndroidSchedulers.mainThread()).
                 subscribe(subscriber);
     }

