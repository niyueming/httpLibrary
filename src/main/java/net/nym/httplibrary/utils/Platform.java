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

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author niyueming
 * @date 2017-02-06
 * @time 08:52
 */

public class Platform {
    private final static String TAG = Platform.class.getSimpleName();
    private static final Platform PLATFORM = findPlatform();

    public static Platform get(){
        Log.e(TAG,PLATFORM.getClass().toString());
        return PLATFORM;
    }

    private static Platform findPlatform(){
        try{
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0){
                return new Android();
            }
        } catch (ClassNotFoundException ignored){
        }
        return new Platform();
    }

    public Executor defaultCallbackExecutor(){
        return Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable){
        defaultCallbackExecutor().execute(runnable);
    }


    static class Android extends Platform{
        @Override
        public Executor defaultCallbackExecutor(){
            return new MainThreadExecutor();
        }

        static class MainThreadExecutor implements Executor{
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable r){
                handler.post(r);
            }
        }
    }
}
