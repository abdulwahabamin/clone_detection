    public <T> Observable<T> getObservable(String key) {

        MemoryItem<T> memoryItem = memoryCache.get(key);

        return (memoryItem != null && memoryItem.isValid()) ? Observable.just(memoryItem.getItem()) : Observable.empty();
    }

