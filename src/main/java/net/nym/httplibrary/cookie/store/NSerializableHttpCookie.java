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

package net.nym.httplibrary.cookie.store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author niyueming
 * @date 2017-02-06
 * @time 09:18
 */

public abstract class NSerializableHttpCookie<COOKIE> implements Serializable{
    private static final long serialVersionUID = 6374381323722046732L;

    protected transient final COOKIE cookie;
    protected transient COOKIE clientCookie;

    public NSerializableHttpCookie(COOKIE cookie)
    {
        this.cookie = cookie;
    }

    public COOKIE getCookie()
    {
        COOKIE bestCookie = cookie;
        if (clientCookie != null)
        {
            bestCookie = clientCookie;
        }

        return bestCookie;
    }

    protected abstract void writeObject(ObjectOutputStream out) throws IOException;

    protected abstract void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException;
}
