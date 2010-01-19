package org.apache.solr.cloud;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// effectively immutable
public class CloudState {
  private Map<String,List<Slice>> collectionStates = new HashMap<String,List<Slice>>();
  private List<String> liveNodes = null;
  
  public CloudState(List<String> liveNodes) {
    this.liveNodes = liveNodes;
  }
  
  // nocommit : only call before publishing
  void addSlices(String collection, List<Slice> slices) {
    collectionStates.put(collection, slices);
  }
  
  // nocommit
  public List<Slice> getSlices(String collection) {
    return Collections.unmodifiableList(collectionStates.get(collection));
  }
  
  public List<String> getLiveNodes() {
    return Collections.unmodifiableList(liveNodes);
  }

}
