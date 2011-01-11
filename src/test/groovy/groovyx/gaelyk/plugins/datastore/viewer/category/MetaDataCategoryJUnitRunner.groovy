/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovyx.gaelyk.plugins.datastore.viewer.category

import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.Statement
import groovyx.gaelyk.GaelykCategory

/**
 * JUnitRunner for metadata category. It also mixes in the GaelykCategory.
 *
 * @author Benjamin Muschko
 */
class MetaDataCategoryJUnitRunner extends BlockJUnit4ClassRunner {
    public MetaDataCategoryJUnitRunner(Class klass) {
        super(klass)
    }

    protected Statement methodBlock(FrameworkMethod method) {
        def stmt = super.methodBlock(method);

        return {
            use([MetaDataCategory, GaelykCategory]) {
                stmt.evaluate()
            }
        } as Statement
    }
}