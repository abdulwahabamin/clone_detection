        void upload() {
            synchronized (sLock) {
                isUploading = true;
            }
            int size = queries.size();
            if (size == 0 && newquery == null) return;
            //Max 50 Scrobbles per Request (restriction by LastFM)
            if (size > 50) size = 50;
            if (newquery != null && size > 49) size = 49;
            final String currentqueries[] = new String[size];
            int n = 0;
            for (String t : queries) {
                currentqueries[n++] = t;
                if (n >= size) break;
            }

            TreeMap<String, String> fields = new TreeMap<>();
            fields.put("method", ScrobbleQuery.Method);
            fields.put("api_key", API_KEY);
            fields.put("sk", mUserSession.mToken);

            int i = 0;
            for (String squery : currentqueries) {
                ScrobbleQuery query = new ScrobbleQuery(squery);
                fields.put("artist[" + i + ']', query.mArtist);
                fields.put("track[" + i + ']', query.mTrack);
                fields.put("timestamp[" + i + ']', Long.toString(query.mTimestamp));
                i++;
            }
            if (newquery != null) {
                fields.put("artist[" + i + ']', newquery.mArtist);
                fields.put("track[" + i + ']', newquery.mTrack);
                fields.put("timestamp[" + i + ']', Long.toString(newquery.mTimestamp));
            }
            String sig = "";
            for (Map.Entry<String, String> ent : fields.entrySet()) {
                sig += ent.getKey() + ent.getValue();
            }
            sig += API_SECRET;
            mUserRestService.getScrobbleInfo(generateMD5(sig), JSON, fields, new Callback<ScrobbleInfo>() {
                @Override
                public void success(ScrobbleInfo scrobbleInfo, Response response) {
                    synchronized (sLock) {
                        isUploading = false;
                        cachedirty = true;
                        if (newquery != null) newquery = null;

                        for (String squery : currentqueries) {
                            queries.remove(squery);
                        }
                        if (queries.size() > 0)
                            upload();
                        else
                            save();

                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    synchronized (sLock) {
                        isUploading = false;
                        //Max 500 scrobbles in Cache
                        if (newquery != null && queries.size() <= 500)
                            queries.add(newquery.toString());

                        if (cachedirty)
                            save();
                    }
                }
            });


        }

