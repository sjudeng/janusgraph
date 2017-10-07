// Copyright 2017 JanusGraph Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.janusgraph.hadoop;

import org.janusgraph.CassandraStorageSetup;
import org.janusgraph.diskstorage.cassandra.utils.CassandraDaemonWrapper;
import org.janusgraph.diskstorage.configuration.ModifiableConfiguration;
import org.janusgraph.diskstorage.configuration.WriteConfiguration;

public class CassandraIndexManagementIT extends AbstractIndexManagementIT {

    @Override
    public WriteConfiguration getConfiguration() {
        String className = getClass().getSimpleName();
        final ModifiableConfiguration mc;
        if ( CassandraDaemonWrapper.isStarted()) {
            mc = CassandraStorageSetup.getEmbeddedConfiguration(className);
        }  else {
            mc = CassandraStorageSetup.getCassandraThriftConfiguration(className);
        }
        return mc.getConfiguration();
    }
}
