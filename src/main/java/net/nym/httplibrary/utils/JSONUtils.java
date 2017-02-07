/*
 * Copyright (c) 2017  Ni YueMing<niyueming@163.com>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */

package net.nym.httplibrary.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author niyueming
 * @date 2017-02-07
 * @time 15:23
 */

public class JSONUtils {

    public static boolean isJSONObject(String str){
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    public static boolean isJSONArray(String str){
        try {
            new JSONArray(str);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}
