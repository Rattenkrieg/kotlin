/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package kotlin

import kotlin.annotation.AnnotationTarget.*
import kotlin.internal.RequireKotlin
import kotlin.internal.RequireKotlinVersionKind

/**
 * Marks the API which usages is dependent on the experimental builder inference.
 *
 * Experimental builder inference will not be enabled for usages of such API unless
 * an explicit opt-in with the [UseExperimental] annotation is done on the declaration site.
 */
@Experimental(level = Experimental.Level.ERROR)
@Target(CLASS, CONSTRUCTOR, VALUE_PARAMETER, FUNCTION, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
@SinceKotlin("1.3")
@ExperimentalBuilderInference
public annotation class ExperimentalBuilderInference


