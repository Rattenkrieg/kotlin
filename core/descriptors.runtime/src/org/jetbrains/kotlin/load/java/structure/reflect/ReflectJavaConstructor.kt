/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.load.java.structure.reflect

import org.jetbrains.kotlin.load.java.structure.JavaAnnotation
import org.jetbrains.kotlin.load.java.structure.JavaConstructor
import org.jetbrains.kotlin.load.java.structure.JavaTypeParameter
import org.jetbrains.kotlin.load.java.structure.JavaValueParameter
import org.jetbrains.kotlin.name.FqName
import java.lang.reflect.Constructor
import java.lang.reflect.Modifier
import java.util.Arrays

public class ReflectJavaConstructor(constructor: Constructor<*>) : ReflectJavaMember(constructor), JavaConstructor {
    private val constructor: Constructor<*>
        get() = member as Constructor<*>

    override fun getAnnotations(): Collection<JavaAnnotation> {
        // TODO
        return listOf()
    }

    override fun findAnnotation(fqName: FqName): JavaAnnotation? {
        // TODO
        return null
    }

    override fun getValueParameters(): List<JavaValueParameter> =
            getValueParameters(
                    dropSynthetic(constructor.getGenericParameterTypes()),
                    dropSynthetic(constructor.getParameterAnnotations()),
                    constructor.isVarArgs()
            )

    // Constructors of inner classes have one additional synthetic parameter
    // TODO: test this code with annotations on constructor parameters of enums and inner classes
    private inline fun <reified T> dropSynthetic(array: Array<T>): Array<T> {
        val klass = constructor.getDeclaringClass()
        return if (klass.getDeclaringClass() != null && !Modifier.isStatic(klass.getModifiers())) {
            Arrays.copyOfRange(array, 1, array.size())
        }
        else array
    }

    override fun getTypeParameters(): List<JavaTypeParameter> {
        // TODO
        return listOf()
    }
}
