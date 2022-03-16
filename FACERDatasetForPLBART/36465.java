    /**
     * 在RxJava的使用过程中我们会频�?的调用subscribeOn()和observeOn(),通过Transformer结�?�
     * Observable.compose()我们�?�以�?用这些代�?
     *
     * @return Transformer
     */
    public static <T> Observable.Transformer<T, T> normalSchedulersTransformer() {

        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

