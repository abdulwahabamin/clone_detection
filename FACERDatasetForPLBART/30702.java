    @Override
    public void detachView(boolean retainInstance) {

        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {

            compositeSubscription.unsubscribe();
        }
        super.detachView(retainInstance);
    }

