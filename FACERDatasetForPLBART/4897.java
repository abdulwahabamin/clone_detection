    public static synchronized void trimCache() {
        if(IC.cacheorder.size()>IC.MAX_CACHE) {
            String rem = IC.cacheorder.remove(0);
            IC.cache.remove(rem);
        }
        System.gc();
    }

