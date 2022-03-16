        public  final boolean  remThumbnailIfOld( int ttl ) { 
            if( thumbnail != null && !need_thumb && System.currentTimeMillis() - thumbnailUsed > ttl ) {
                thumbnail = null;
                return true;
            }
            return false;
        }

