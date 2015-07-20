/*
 * Copyright 2013 JBoss Inc
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

package org.optaplanner.core.impl.domain.variable.listener;

import org.optaplanner.core.impl.domain.variable.supply.Supply;
import org.optaplanner.core.impl.score.director.ScoreDirector;

/**
 * Changes shadow variables when a genuine planning variable changes.
 * <p>
 * Important: it must only change the shadow variable for which it's configured!
 * It should never change a genuine variable or a problem fact.
 * It can change its shadow variable on multiple entity instances
 * (for example: an arrivalTime change affects all trailing entities too)
 * <p>
 * Each {@link ScoreDirector} has a different {@link VariableListener} instance, so it can be stateful.
 * If it is stateful, it should implement {@link StatefulVariableListener}.
 */
public interface VariableListener<EntityG> extends Supply {

    void beforeEntityAdded(ScoreDirector scoreDirector, EntityG entity);

    void afterEntityAdded(ScoreDirector scoreDirector, EntityG entity);

    void beforeVariableChanged(ScoreDirector scoreDirector, EntityG entity);

    void afterVariableChanged(ScoreDirector scoreDirector, EntityG entity);

    void beforeEntityRemoved(ScoreDirector scoreDirector, EntityG entity);

    void afterEntityRemoved(ScoreDirector scoreDirector, EntityG entity);

}
