    public void clearFromMemoryCache(String tag){
        if (unavailable.contains(tag + SIZE_THUMB)) {
        	unavailable.remove(tag + SIZE_THUMB);
        }
        if (pendingImagesMap.get(tag + SIZE_THUMB)!=null){
        	pendingImagesMap.remove(tag + SIZE_THUMB);
        }
        if (memCache.get(tag + SIZE_THUMB)!=null){
        	memCache.remove(tag + SIZE_THUMB);
        }
        if (unavailable.contains(tag + SIZE_NORMAL)) {
        	unavailable.remove(tag + SIZE_NORMAL);
        }
        if (pendingImagesMap.get(tag + SIZE_NORMAL)!=null){
        	pendingImagesMap.remove(tag + SIZE_NORMAL);
        }
        if (memCache.get(tag + SIZE_NORMAL)!=null){
        	memCache.remove(tag + SIZE_NORMAL);
        }
    }

