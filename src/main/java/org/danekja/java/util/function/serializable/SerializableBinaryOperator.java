/*
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jakub Danek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 *  Please visit https://github.com/danekja/jdk-function-serializable if you need additional information or have any
 *  questions.
 *
 */

package org.danekja.java.util.function.serializable;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.BinaryOperator;

/**
 * Serializable version of {@link SerializableBinaryOperator}
 *
 * @author Jakub Danek (www.danekja.org)
 *
 */
@FunctionalInterface
public interface SerializableBinaryOperator<T> extends BinaryOperator<T>, Serializable {
	/**
	 * Returns a {@link SerializableBinaryOperator} which returns the lesser of
	 * two elements according to the specified {@code Comparator}.
	 *
	 * @param <T> the type of the input arguments of the comparator
	 * @param comparator a {@code Comparator} for comparing the two values
	 * @return a {@code SerializableBinaryOperator} which returns the lesser of
	 *         its operands, according to the supplied {@code Comparator}
	 * @throws NullPointerException if the argument is null
	 */
	public static <T> SerializableBinaryOperator<T> minBy(Comparator<? super T> comparator) {
		Objects.requireNonNull(comparator);
		return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
	}

	/**
	 * Returns a {@link SerializableBinaryOperator} which returns the greater of
	 * two elements according to the specified {@code Comparator}.
	 *
	 * @param <T> the type of the input arguments of the comparator
	 * @param comparator a {@code Comparator} for comparing the two values
	 * @return a {@code SerializableBinaryOperator} which returns the greater of
	 *         its operands, according to the supplied {@code Comparator}
	 * @throws NullPointerException if the argument is null
	 */
	public static <T> SerializableBinaryOperator<T> maxBy(Comparator<? super T> comparator) {
		Objects.requireNonNull(comparator);
		return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
	}
}
