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


import java.net.URI;
import java.util.List;

/**
 * @author niyueming
 * @date 2017-02-06
 * @time 09:11
 */

public interface NCookieStore<COOKIE> {
    void add(URI uri, List<COOKIE> cookie);

    List<COOKIE> get(URI uri);

    List<COOKIE> getCookies();

    boolean remove(URI uri, COOKIE cookie);

    boolean removeAll();
}
