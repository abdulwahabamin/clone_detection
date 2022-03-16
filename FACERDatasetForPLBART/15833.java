        public JSONObject toJson()throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("inetAddress", inetAddress.getHostAddress());
            jsonObject.put("port", port);
            return jsonObject;
        }

