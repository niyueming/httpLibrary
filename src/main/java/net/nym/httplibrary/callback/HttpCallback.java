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

package net.nym.httplibrary.callback;

import net.nym.httplibrary.https.NCallback;

/**
 * @author niyueming
 * @date 2017-02-07
 * @time 10:58
 */

public abstract class HttpCallback<REQUEST,RESPONSE,RESULT> implements NCallback {

    /**
     * UI Thread
     * @param request
     * @param id
     */
    public void onBefore(REQUEST request,int id){

    }

    /**
     * UI Thread
     * @param id
     */
    public void onAfter(int id){

    }

    /**
     * UI Thread
     * @param progress  byte
     * @param total     byte
     * @param id        byte
     */
    public void inProgress(long progress, long total,int id){

    }

    /**
     * 如果要用parseNetworkResponse方法解析数据，这个方法要返回true
     * @param response
     * @param id
     * @return
     */
    public boolean validateResponse(RESPONSE response, int id){
        return false;
    }

    /**
     * Thread Pool Thread
     * @param response
     * @param id
     * @return
     * @throws Exception
     */
    public abstract RESULT parseNetworkResponse(RESPONSE response,int id)throws Exception;

    public abstract void onError(Exception e,String error,int id);

    public abstract void onResponse(REQUEST request,int id);
}
