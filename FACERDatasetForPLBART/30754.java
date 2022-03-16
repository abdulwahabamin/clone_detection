    public MemoryItem(T item, long validationPeriod) {

        this.item = item;
        this.validationPeriod = validationPeriod;
        timeStamp = System.currentTimeMillis();
    }

